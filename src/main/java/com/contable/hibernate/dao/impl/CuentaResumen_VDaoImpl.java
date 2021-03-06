package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.DateUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.dao.CuentaResumen_VDao;
import com.contable.hibernate.model.CuentaResumen_V;

@Repository("cuentaResumen_VDao")
public class CuentaResumen_VDaoImpl extends GenericDaoImpl<CuentaResumen_V, Integer> implements CuentaResumen_VDao{

	@Override
	protected Class<CuentaResumen_V> getEntityClass() {
		return CuentaResumen_V.class;
	}

	@Transactional
	public  List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, String orderField, boolean orderAsc) {

		return buscarSaldoAnteriorCuentaByFiltrosBuscarMoneda(	 filtro,  orderField, null ,  orderAsc);
	
	}
	
	
	@Transactional
	@SuppressWarnings("unchecked")
	public  List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltrosBuscarMoneda(	FiltroCuentaBean filtro, String orderField,Integer monedaIdMonstrarEn, boolean orderAsc) {
		String cotizacionField = "rcm.`Cotizacion` `cotizacion`, 1 as `cotizacionAconvertir`,";
		if (monedaIdMonstrarEn != null) {
			cotizacionField = "rcm.`Cotizacion` `cotizacion`,dc.`Cotizacion` `cotizacionAconvertir`,";
		} 

		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("select `IdAdministracion` AS `administracionId`, `FechaIngreso` `fecha`, `TipoDocumentoNombre` `tipoDocumentoNombre`, `NumeroLetra`, `NumeroEstablecimiento`, " +
				"`NumeroAnio`, `NumeroMes`, `NumeroDia`, `Numero`, `DocDescripcion` ,rcm.`IdDocumento` `documentoId`, `IdMovimiento` `movimientoId`, `Descripcion` , `IdCuenta` `cuentaId`," +
				" `IdTipoEntidad` `tipoEntidadId`, `IdEntidad` `entidadId`, rcm.`IdMoneda` `monedaId`, " + cotizacionField +
				" `MonedaNombre`, `MonedaCodigo`, `CuentaNombre`, " +
				" `EntidadNombre`, `TipoEntidadNombre`, `Debito` `debito`, `Credito` `credito` , `Referencia` `referencia`, `AplicacionesEnDocumento` `aplicacionesEnDocumento` " +
				" , `Estado`, `IdDocumentoAnulaa` DocumentoAnulaaId, `IdDocumentoAnuladoPor` documentoAnuladoPorId ");
		
		/*FROM*/
		queryStr.append(" from resumencuentamovimientos_v rcm ");
		if (monedaIdMonstrarEn != null) {
			queryStr.append(" left join documentomovimientoscotizaciones dc on (dc.IdDocumento = rcm.IdDocumento AND dc.IdMoneda = '"+ monedaIdMonstrarEn +"') ");
		}
		/*WHERE*/
		queryStr.append("WHERE ");
		//fecha
		queryStr.append(" '1' = '1' ");
		//cuenta
		if (filtro.getAdministracionId() != null && filtro.getAdministracionId() > 0)
			queryStr.append(" AND `IdAdministracion` = '"+filtro.getAdministracionId()+"' ");
		if (filtro.getCuentaId() != null && filtro.getCuentaId() > 0)
			queryStr.append(" AND `IdCuenta` = '"+filtro.getCuentaId()+"' ");
		if (filtro.getTipoEntidadId() != null && filtro.getTipoEntidadId() > 0)
			queryStr.append(" AND `IdTipoEntidad` = '"+filtro.getTipoEntidadId()+"' ");
		if (StringUtils.isNotBlank(filtro.getEntidadId()))
			queryStr.append(" AND `IdEntidad` in ("+filtro.getEntidadId().replace("{", "").replace("{", "")+") ");
		if (filtro.getMonedaId() != null && filtro.getMonedaId() > 0)
			queryStr.append(" AND rcm.`IdMoneda` = '"+filtro.getMonedaId()+"' ");
		if (StringUtils.isNotBlank(filtro.getFechaDesde()))
			queryStr.append(" AND `FechaIngreso` >= :fechaDesde ");
		if (StringUtils.isNotBlank(filtro.getFechaHasta()))
			queryStr.append(" AND `fechaIngreso` <= :fechaHasta ");
		if (StringUtils.isNotBlank(filtro.getReferencia()))
			queryStr.append(" AND `Referencia` like '%"+filtro.getReferencia()+"%' ");

		if (orderAsc) {
			queryStr.append(" ORDER BY " + orderField + " asc ");
		} else {
			queryStr.append(" ORDER BY " + orderField + " desc ");
		}
		
		Query query = getSession().createSQLQuery(queryStr.toString())
				.addScalar("administracionId")
				.addScalar("cuentaId")
				.addScalar("tipoEntidadId")
				.addScalar("tipodocumentoNombre")
				.addScalar("entidadId")
				.addScalar("documentoId")
				.addScalar("monedaId")
				.addScalar("monedaNombre")
				.addScalar("monedaCodigo")
				.addScalar("cuentaNombre")
				.addScalar("entidadNombre")
				.addScalar("tipoEntidadNombre")
				.addScalar("fecha")
				.addScalar("numeroLetra")
				.addScalar("numeroEstablecimiento")
				.addScalar("numeroAnio")
				.addScalar("numeroMes")
				.addScalar("numeroDia")
				.addScalar("numero")
				.addScalar("referencia")
				.addScalar("docDescripcion")
				.addScalar("aplicacionesEnDocumento",Hibernate.BIG_INTEGER)
				.addScalar("debito",Hibernate.STRING)
				.addScalar("credito",Hibernate.STRING)
				.addScalar("cotizacion",Hibernate.STRING)
				.addScalar("cotizacionAconvertir",Hibernate.STRING)
				.addScalar("estado")
				.addScalar("documentoAnulaaId")
				.addScalar("documentoAnuladoPorId")				
				.setResultTransformer( Transformers.aliasToBean(CuentaBusquedaForm.class));
				
		if (StringUtils.isNotBlank(filtro.getFechaDesde()))		
			query.setDate("fechaDesde", DateUtil.convertStringToDate(filtro.getFechaDesde()));
		if (StringUtils.isNotBlank(filtro.getFechaHasta()))
			query.setDate("fechaHasta", DateUtil.convertStringToDate(filtro.getFechaHasta()));


		List<CuentaBusquedaForm> result = query.list();
		
		return result;
	
	}	
}
