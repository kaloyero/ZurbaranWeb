package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.RolForm;
import com.contable.hibernate.model.Rol;

public class RolMapper extends MapperImpl<Rol,RolForm>{


	public Rol getEntidad(RolForm form) {
		Rol ent = new Rol();
		if (form != null){		
			ent.setId(((RolForm) form).getId());
			ent.setNombre(((RolForm) form).getNombre());
			ent.setDescripcion(((RolForm) form).getDescripcion());
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
		}
		return ent;
	}

	public  RolForm getForm(Rol ent) {
		RolForm form=new RolForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setDescripcion(ent.getDescripcion());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}


}