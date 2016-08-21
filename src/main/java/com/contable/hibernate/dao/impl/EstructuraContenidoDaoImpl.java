package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EstructuraContenidoDao;
import com.contable.hibernate.model.EstructuraContenido;

@Repository("estructuraContenidoDao")
public class EstructuraContenidoDaoImpl extends GenericDaoImpl<EstructuraContenido, Integer> implements EstructuraContenidoDao{

	@Override
	protected Class<EstructuraContenido> getEntityClass() {
		return EstructuraContenido.class;
	}

	@Override
	public boolean delete(int idDocumento) {
		getSession().createSQLQuery("DELETE FROM `estructuracontenidocuentas` WHERE `IdEstructuraContenido` = "+idDocumento).executeUpdate();
		getSession().createSQLQuery("DELETE FROM `estructurascontenido` WHERE `Id` = "+idDocumento).executeUpdate();
		return true;
	}	
}
