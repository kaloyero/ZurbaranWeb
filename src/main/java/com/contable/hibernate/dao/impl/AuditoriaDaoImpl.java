package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.AuditoriaDao;
import com.contable.hibernate.model.Auditoria;

@Repository("auditoriaDao")
public class AuditoriaDaoImpl extends GenericDaoImpl<Auditoria, Integer> implements AuditoriaDao{

	@Override
	protected Class<Auditoria> getEntityClass() {
		return Auditoria.class;
	}

}
