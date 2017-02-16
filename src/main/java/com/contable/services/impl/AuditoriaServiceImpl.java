package com.contable.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.constants.AuditoriaTipo;
import com.contable.hibernate.dao.AuditoriaDao;
import com.contable.hibernate.model.Auditoria;
import com.contable.services.AuditoriaService;

@Service("auditoriaService")
public class AuditoriaServiceImpl extends AbstractServiceImpl<Auditoria>
		implements AuditoriaService {

	@Autowired
	private AuditoriaDao auditoriaDao;

	protected GenericDao<Auditoria, Integer> getDao() {
		return auditoriaDao;
	}

	@Override
	public void saveAuditoria(Integer idDocumento, AuditoriaTipo accion,
			Integer usuario) {
		Auditoria auditoria = new Auditoria(idDocumento,null, accion,
				usuario, new Date());
		this.save(auditoria);
	}

	@Override
	public List<Auditoria> getAuditoriaByDocumentId(Integer idDocumento) {
		return auditoriaDao.findAllByProperty("idDocumento", idDocumento, false);
	}

	
}
