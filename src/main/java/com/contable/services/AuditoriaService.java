package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.constants.AuditoriaTipo;
import com.contable.hibernate.model.Auditoria;

public interface AuditoriaService extends AbstractService<Auditoria> {

	void saveAuditoria(Integer idDocumento, AuditoriaTipo accion, Integer usuario);

	List<Auditoria> getAuditoriaByDocumentId(Integer idDocumento);
}

