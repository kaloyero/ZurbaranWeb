package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.DocumentoMovimientoCotizacionDao;
import com.contable.hibernate.model.DocumentoMovimientoCotizacion;
import com.contable.services.DocumentoMovimientoCotizacionService;

@Service("DocumentoMovimientoCotizacionService")
public class DocumentoMovimientoCotizacionServiceImpl extends AbstractServiceImpl<DocumentoMovimientoCotizacion> implements DocumentoMovimientoCotizacionService{

	@Autowired
    private DocumentoMovimientoCotizacionDao documentoMovimientoCotizacionDao;

	protected GenericDao<DocumentoMovimientoCotizacion, Integer> getDao() {
		return documentoMovimientoCotizacionDao;
	}

	@Override
	public List<DocumentoMovimientoCotizacion> getCotizacionesByIdDocumento(
			int idDocumento) {
		return documentoMovimientoCotizacionDao.findAllByProperty("documentoId", idDocumento, false);

	}
	

}
