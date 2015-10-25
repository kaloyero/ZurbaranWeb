package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.RolForm;
import com.contable.hibernate.model.Opcion;
import com.contable.hibernate.model.Rol;
import com.contable.manager.RolManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/rol")
public class RolController extends ConfigurationControllerImpl<Rol, RolForm> {
	
	@Autowired
	private RolManager rolManager;

	@Override
	protected ConfigurationManager<Rol, RolForm> getRelatedManager() {
		return rolManager;
	}

	
	public List <String> getRowDataList(RolForm formRow){
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getNombre()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getDescripcion()));
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add(BOTON_LISTADO_ELIMINAR+
				BOTON_LISTADO_CAMBIARESTADO +
				BOTON_LISTADO_EDITAR);		
		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		
		//Obtengo todas las opciones activas del sistema
		model.addAttribute("opcionesSistemaTodas", rolManager.obtenerOpcionesSistemaActivas());
		model.addAttribute("opcionesSistemaSeleccionados", new ArrayList<Opcion>());
		model.addAttribute("Rol", new RolForm());
		
		return "configuraciones/rol";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{

		RolForm rol =rolManager.findById(id);
		
		//Obtengo todas las opciones activas del sistema que el usuario no agrego
		model.addAttribute("opcionesSistemaTodas", rolManager.obtenerOpcionesSistemaActivasNoAgregadas(rol.getOpcionesSeleccionadasTodo()));
		
		

		model.addAttribute("Rol", rol);
	    return "configuraciones/editRol";
	}



}
