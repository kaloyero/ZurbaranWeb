package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.OpcionDao;
import com.contable.hibernate.model.Opcion;

@Repository("opcionDao")
public class OpcionDaoImpl extends GenericDaoImpl<Opcion, Integer> implements OpcionDao{

	@Override
	protected Class<Opcion> getEntityClass() {
		return Opcion.class;
	}

	@Transactional
	public List<Opcion> obtenerTodasOpcionesSistemaActivas(){
	
		List<Property> filtros = new ArrayList<Property>();
		
		filtros.add(new Property(Restrictions.eq("estado", Constants.BD_ACTIVO), Property.OPERATOR_AND));
		
		return getAll(filtros, "orden", true);
		
	}
}
