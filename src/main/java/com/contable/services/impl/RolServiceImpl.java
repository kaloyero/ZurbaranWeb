package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.OpcionDao;
import com.contable.hibernate.dao.RolDao;
import com.contable.hibernate.model.Opcion;
import com.contable.hibernate.model.Rol;
import com.contable.services.RolService;

@Service("rolService")
public class RolServiceImpl extends AbstractServiceImpl<Rol> implements RolService{

	@Autowired
    private RolDao rolDao;

	@Autowired
    private OpcionDao opcionDao;
		
	protected GenericDao<Rol, Integer> getDao() {
		return rolDao;
	}
	
	public List<Opcion> obtenerOpcionesSistemaActivas(){
		return opcionDao.obtenerTodasOpcionesSistemaActivas();
	}
	
	@Transactional
	public Rol findById(int id) {
		Rol rol = getDao().findById(id);
		
		for (Opcion op : rol.getAccesoOciones()) {
			op.getCodigo();
		}
		
		return rol;
	}
	

	
}
