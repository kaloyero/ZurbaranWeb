package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Opcion;

public interface OpcionDao extends GenericDao<Opcion, Integer> {

	public List<Opcion> obtenerTodasOpcionesSistemaActivas();
}
