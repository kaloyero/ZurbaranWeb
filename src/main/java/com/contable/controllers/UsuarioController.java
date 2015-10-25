package com.contable.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.UsuarioForm;
import com.contable.hibernate.model.Usuario;
import com.contable.manager.RolManager;
import com.contable.manager.UsuarioManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController extends ConfigurationControllerImpl<Usuario, UsuarioForm> {
	
	@Autowired
	private UsuarioManager usuarioManager;
	@Autowired
	private RolManager rolManager;
	
	@Override
	protected ConfigurationManager<Usuario, UsuarioForm> getRelatedManager() {
		return usuarioManager;
	}
	
	@Override
	protected List<String> getRowDataList(UsuarioForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(formRow.getUsername());
		row.add(formRow.getEmail());
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));
		row.add(BOTON_LISTADO_ELIMINAR+
				BOTON_LISTADO_CAMBIARESTADO +
				BOTON_LISTADO_EDITAR);
		return row;
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		
		List<ConfigBean> rolesDeUsuario =rolManager.getConfigNameList();
		model.addAttribute("rolesDeUsuario", rolesDeUsuario);
		
		model.addAttribute("Usuario", new UsuarioForm());
	   return "configuraciones/usuario";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody  ErrorRespuestaBean guardar(@ModelAttribute(value = "Form") UsuarioForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		//TODO cambiar
		form.setValidaPassword("T");
		form.setValidaRol("T");
		form.setEstado("T");
		
		ErrorRespuestaBean respuesta=getRelatedManager().guardarNuevo(form);		
		return respuesta;
	}


	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		UsuarioForm usuario =usuarioManager.findById(id);

		//obtengo los roles de usuario
		List<ConfigBean> rolesDeUsuario =rolManager.getConfigNameList();
		model.addAttribute("rolesDeUsuario", rolesDeUsuario);
		
		model.addAttribute("Usuario", usuario);
	   return "configuraciones/editUsuario";
	}
	
	
	
}
