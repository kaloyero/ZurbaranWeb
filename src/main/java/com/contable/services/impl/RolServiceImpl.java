package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.RolDao;
import com.contable.hibernate.model.Rol;
import com.contable.services.RolService;

@Service("rolService")
public class RolServiceImpl extends AbstractServiceImpl<Rol> implements RolService{

	@Autowired
    private RolDao rolDao;

	protected GenericDao<Rol, Integer> getDao() {
		return rolDao;
	}
	

}
