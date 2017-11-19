package com.contable.hibernate.dao;

import java.util.Date;
import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.model.CuentaSaldo_V;

public interface CuentaSaldo_VDao extends GenericDao<CuentaSaldo_V, Integer> {

	//public List<CuentaBusquedaForm> buscarSaldoCuentaFiltros(	FiltroCuentaBean filtro, String anio, String mes, String campoOrder, boolean orderByAsc);
	
	public List<CuentaBusquedaForm> buscarSaldoCuentaActualByFiltros (	FiltroCuentaBean filtro, Date fechaDesde, String fechaHasta,String campoOrder, boolean orderByAsc);
	public List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, String anioMesDesde, String anioMesHasta, String campoOrder, boolean orderByAsc);
	public Double getQryCotizBaseMoneda(Integer idMonedaAMostrar,Integer idMonedaDocumento,String fecha,Integer cuentaId,Integer tipoEntidadId,String idEntidad);
	
}
