package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.TipoDocumentoDao;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.services.DocumentoTipoService;

@Service("documentoTipoService")
public class DocumentoTipoServiceImpl extends AbstractServiceImpl<TipoDocumento> implements DocumentoTipoService{

	@Autowired
    private TipoDocumentoDao documentoTipoDao;

	protected GenericDao<TipoDocumento, Integer> getDao() {
		return documentoTipoDao;
	}
	

}
