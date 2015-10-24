package com.contable.services.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.DocumentoUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.dao.CuentaDao;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.dao.CuentaResumen_VDao;
import com.contable.hibernate.dao.CuentaSaldo_VDao;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.services.CuentaService;

@Service("cuentaService")
public class CuentaServiceImpl extends AbstractServiceImpl<Cuenta> implements CuentaService{

	@Autowired
    private CuentaDao cuentaDao;

	@Autowired
    private CuentaMonedaDao cuentaMonedaDao;

	@Autowired
    private CuentaResumen_VDao cuentaResumen_VDao;

	@Autowired
    private CuentaSaldo_VDao cuentaSaldo_VDao;

	protected GenericDao<Cuenta, Integer> getDao() {
		return cuentaDao;
	}
	
	@Transactional
	public Integer save(Cuenta dto) {
		Integer a = getDao().save(dto);
		
		return a;
	}

	@Transactional
	public void saveCuentaMoneda(List<CuentaMoneda> dto) {
		cuentaMonedaDao.save(dto);
	}

	@Transactional
	public void updateCuentaMoneda(List<Integer> idsMonedas, int idCuenta) {
		cuentaMonedaDao.update(idsMonedas, idCuenta);
	}

	
	@Transactional
	public List<CuentaMoneda> findCuentaMoneda(int idCuenta) {
		return cuentaMonedaDao.getMonedasByIdCuenta(idCuenta);
	}

	@Transactional
	public List<ConfigBean> findCuentaMonedaConfig(int idCuenta) {
		return cuentaMonedaDao.getMonedasConfigByIdCuenta(idCuenta);
	}

	public List<CuentaBusquedaForm> buscarResumenPorFiltros(FiltroCuentaBean filtros, String orderField, boolean orderAsc) {
			List<CuentaBusquedaForm> list = cuentaResumen_VDao.buscarSaldoAnteriorCuentaByFiltros(filtros,orderField,orderAsc);
			
			//Ordeno el resumen por fecha
			list = ordenarResumen(list);
			
			for (CuentaBusquedaForm form : list) {
				form.setFechaIngreso(DateUtil.convertDateToString(form.getFecha()));
				form.setNumeroFormateado(DocumentoUtil.getNumeroFormato(form.getNumeroLetra(), form.getNumeroEstablecimiento(), form.getNumeroAnio(), form.getNumeroMes(), form.getNumeroDia(), form.getNumero()));
				form.setDebito(FormatUtil.format2DecimalsStr(form.getDebito()));
				form.setCredito(FormatUtil.format2DecimalsStr(form.getCredito()));
			}
			
		return list;

	}
	
	private List<CuentaBusquedaForm> ordenarResumen(Collection<CuentaBusquedaForm> resumen){
		
		List<CuentaBusquedaForm> list = new ArrayList<CuentaBusquedaForm>(resumen);
		
		Collections.sort(list, new Comparator<CuentaBusquedaForm>(){
			 
			public int compare(CuentaBusquedaForm o1, CuentaBusquedaForm o2) {
				Date fecha1 = o1.getFecha();
				Date fecha2 = o2.getFecha();
				return fecha1.compareTo(fecha2);
			}
		});
		
		return list;
	}

	
	public List<CuentaBusquedaForm> buscarSaldoPorFiltros(FiltroCuentaBean filtros, String fechaDesde, String fechaHasta, String campoOrden, boolean orderByAsc) {

		List<CuentaBusquedaForm> list = new ArrayList<CuentaBusquedaForm>();
		String anioMesDesde = "";
		/* SI fechaDesde y fecha hasta coinciden en mes y año retorna una lista vacía*/
		if (StringUtils.isNotBlank(fechaDesde) && DateUtil.compararMesAnioIguales(fechaDesde, fechaHasta)){
			return list;
		}
		/* SI no se le pasa la fecha retorna una lista vacía*/
		if (StringUtils.isNotBlank(fechaHasta)){
			//Tomo el mes y el anio de la fecha hasta
			Date fechaSaldoHasta = DateUtil.convertStringToDate(fechaHasta);
			Calendar calendarHasta = Calendar.getInstance();
			calendarHasta.setTime(fechaSaldoHasta);
			String anioHasta = ConvertionUtil.StrValueOf(calendarHasta.get(Calendar.YEAR));
			//Toma de 0 a 11 por lo que no hace falta restarle 1 mes a la fecha
			DecimalFormat mFormat= new DecimalFormat("00");
			String mesHasta =  mFormat.format(Double.valueOf(calendarHasta.get(Calendar.MONTH)));
			String anioMesHasta = anioHasta + mesHasta;
			
			if (StringUtils.isNotBlank(fechaDesde) ){
				//Tomo el mes y el anio de la fecha desde
				Date fechaSaldoDesde = DateUtil.convertStringToDate(fechaDesde);
				Calendar calendarDesde = Calendar.getInstance();
				calendarDesde.setTime(fechaSaldoDesde);
				String anioDesde = ConvertionUtil.StrValueOf(calendarDesde.get(Calendar.YEAR));
				//Toma de 0 a 11 por lo que no hace falta restarle 1 mes a la fecha
				mFormat= new DecimalFormat("00");
				String mesDesde =  mFormat.format(Double.valueOf(calendarDesde.get(Calendar.MONTH)));
				anioMesDesde = anioDesde + mesDesde;
			}

			
			list = cuentaSaldo_VDao.buscarSaldoAnteriorCuentaByFiltros(filtros, anioMesDesde, anioMesHasta, campoOrden, orderByAsc);
		}
			
		return list;

	}


	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros(FiltroCuentaBean filtro, String fechaInicio, String fechaFinal, String campoOrden, boolean orderByAsc) {
		List<CuentaBusquedaForm> list = new ArrayList<CuentaBusquedaForm>();

		Date fechaDesde = null;
		String fechaHasta = fechaFinal;
		
		/* SI no se le pasa la fecha retorna una lista vacía*/
		if (StringUtils.isNotBlank(fechaHasta)){
			/* Pregunto si se cargo una fecha inicial 
			 * Si se cargo, verifico que no sea el mismo mes que la fecha final. En el caso que no se cargue tomo el primer dia de la fecha final
			 * Si la fecha inicial es del mismo mes que la fecha final tomo el dìa de la fecha inicial como fecha desde. Si no es el mismo mes que la fecha final tomo el primer dia de la fecha final*/
			if (DateUtil.compararMesAnioIguales(fechaInicio, fechaHasta)){
				fechaDesde = DateUtil.convertStringToDate(fechaInicio);
			} else {
				fechaDesde = DateUtil.getPrimerDiaMes(fechaHasta);
			}
			
			
			
			list = cuentaSaldo_VDao.buscarSaldoCuentaActualByFiltros(filtro, fechaDesde, fechaHasta, campoOrden, orderByAsc);
		}
	
		return list;

	}

//	public List<CuentaBusquedaForm> buscarSaldoCuenta(FiltroCuentaBean filtros, String campoOrden, boolean orderByAsc) {
//
//		List<CuentaBusquedaForm> list = new ArrayList<CuentaBusquedaForm>();
//		/* SI no se le pasa la fecha retorna una lista vacía*/
//		if (StringUtils.isNotBlank(filtros.getFechaHasta())){
//			//Tomo el mes y el anio
//			Date fecha = DateUtil.convertStringToDate(filtros.getFechaHasta());
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(fecha);
//			String anio = ConvertionUtil.StrValueOf(calendar.get(Calendar.YEAR));
//			//Toma de 0 a 11 por lo que no hace falta restarle 1 mes a la fecha
//			DecimalFormat mFormat= new DecimalFormat("00");
//			String mes =  mFormat.format(Double.valueOf(Calendar.MONTH));
//					
//			
//			list = cuentaSaldo_VDao.buscarSaldoCuentaFiltros(filtros, anio, mes, campoOrden, orderByAsc);
//		}
//			
//		return list;
//
//	}

}
