package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.OpcionForm;
import com.contable.form.RolForm;
import com.contable.hibernate.model.Opcion;
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
	
	public List<Opcion> obtenerOpcionesSistemaActivas(){
		return rolService.obtenerOpcionesSistemaActivas();
	}

	public List<Opcion> obtenerOpcionesSistemaActivasNoAgregadas( Collection<OpcionForm> opcionesAgregadas){
		
		List<Opcion> opsNoAgregadas = new ArrayList<Opcion>();
		List<Opcion> todasLasOpciones = rolService.obtenerOpcionesSistemaActivas();
		
		for (Opcion opTodas : todasLasOpciones) {
			boolean noAgregada = true;
			for (OpcionForm opAgregada : opcionesAgregadas) {
					if (opTodas.getId() == opAgregada.getId()){
						noAgregada = false;	
					}
			}
			if (noAgregada){
				opsNoAgregadas.add(opTodas);
			}
		}
		
		
		return opsNoAgregadas;
	}
	
	@Transactional
	public RolForm findById(Integer id){
		RolMapper mapper = new RolMapper();  
		
		return mapper.getFormComplete(getRelatedService().findById(id) );
	}
	
}
