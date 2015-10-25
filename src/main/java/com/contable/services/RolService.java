package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Opcion;
import com.contable.hibernate.model.Rol;

public interface RolService extends AbstractService<Rol>{

	public List<Opcion> obtenerOpcionesSistemaActivas();
}
