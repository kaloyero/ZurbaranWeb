package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.form.CuentaBusquedaForm;
import com.contable.hibernate.model.CuentaResumen_V;

public interface CuentaResumen_VDao extends GenericDao<CuentaResumen_V, Integer> {

	 List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltros(	FiltroCuentaBean filtro, String orderField, boolean orderAsc);
	
	 List<CuentaBusquedaForm> buscarSaldoAnteriorCuentaByFiltrosBuscarMoneda(	FiltroCuentaBean filtro, String orderField,Integer monedaIdMonstrarEn, boolean orderAsc);
	
}
