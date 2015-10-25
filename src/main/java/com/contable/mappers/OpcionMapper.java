package com.contable.mappers;

import com.contable.form.OpcionForm;
import com.contable.hibernate.model.Opcion;

public class OpcionMapper {


	public static Opcion getEntidad(OpcionForm form) {
		Opcion ent = new Opcion();
		if (form != null){		
			ent.setId(((OpcionForm) form).getId());
			ent.setNombre(((OpcionForm) form).getNombre());
			ent.setOrden(((OpcionForm) form).getOrden());
		}
		return ent;
	}

	public static OpcionForm getForm(Opcion ent) {
		OpcionForm form=new OpcionForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setOrden(ent.getOrden());
		}
		return form;
	}


}