package com.contable.manager;

import java.util.Collection;
import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.form.OpcionForm;
import com.contable.form.RolForm;
import com.contable.hibernate.model.Opcion;
import com.contable.hibernate.model.Rol;

public interface RolManager extends ConfigurationManager<Rol,RolForm>{

	public List<Opcion> obtenerOpcionesSistemaActivas();
	
	public List<Opcion> obtenerOpcionesSistemaActivasNoAgregadas( Collection<OpcionForm> opcionesAgregadas);
}
