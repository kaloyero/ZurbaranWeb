package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.RolForm;
import com.contable.hibernate.model.Rol;
import com.contable.manager.RolManager;
import com.contable.mappers.RolMapper;
import com.contable.services.RolService;

@Service("rolManager")
public class RolManagerImpl extends ConfigurationManagerImpl<Rol,RolForm> implements RolManager{

	@Autowired
	RolService rolService;
	
	@Override
	protected AbstractService<Rol> getRelatedService() {
		return rolService;
	}

	@Override
	protected Mapper<Rol,RolForm> getMapper() {
		return new RolMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Rol.fieldNombre());
//		list.add(Rol.fieldEstado());
		return list;
	}
	
}
