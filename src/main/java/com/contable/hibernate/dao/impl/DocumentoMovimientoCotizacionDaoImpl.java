package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.DocumentoMovimientoCotizacionDao;
import com.contable.hibernate.model.DocumentoMovimientoCotizacion;

@Repository("documentoMovimientoCotizacionDao")
public class DocumentoMovimientoCotizacionDaoImpl extends GenericDaoImpl<DocumentoMovimientoCotizacion, Integer> implements DocumentoMovimientoCotizacionDao{

	@Override
	protected Class<DocumentoMovimientoCotizacion> getEntityClass() {
		return DocumentoMovimientoCotizacion.class;
	}

}
