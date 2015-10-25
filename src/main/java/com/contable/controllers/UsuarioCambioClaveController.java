package com.contable.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contable.common.AbstractControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.constants.ConstantsErrors;
import com.contable.form.UsuarioForm;
import com.contable.hibernate.model.Usuario;
import com.contable.manager.UsuarioManager;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/cambiarClave")
public class UsuarioCambioClaveController extends AbstractControllerImpl<Usuario, UsuarioForm> {
	
	@Autowired
	private UsuarioManager usuarioManager;

	@Override
	protected ConfigurationManager<Usuario, UsuarioForm> getRelatedManager() {
		return usuarioManager;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("Usuario", new UsuarioForm());
	   return "configuraciones/cambiarClave";
	}

	@RequestMapping(value = "/cambiarClave", method = RequestMethod.POST)
	public @ResponseBody  ErrorRespuestaBean cambiarClave(@ModelAttribute(value = "Form") UsuarioForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		//TODO cambiar
		form.setValidaPassword("T");
		form.setValidaRol("T");
		form.setEstado("T");
		
		

		ErrorRespuestaBean respuesta=getRelatedManager().guardarNuevo(form);		
		return respuesta;
	}	
	
	@Override
	protected List<String> getRowDataList(UsuarioForm formRow) {
		// TODO Auto-generated method stub
		return null;
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody  ErrorRespuestaBean guardar(@ModelAttribute(value = "Form") UsuarioForm form,BindingResult result, HttpServletRequest request) throws ParseException{
		ErrorRespuestaBean respuesta = new ErrorRespuestaBean(true);
		boolean login = false;
		
		//compruebo que el usuario sea el logueado
//		UsuarioForm usuario = (UsuarioForm) request.getSession().getAttribute("cart");
//		if (usuario.getUsername().equals(form.getUsername())){
		
			if (form.getNuevaPassword().equals(form.getValidaPassword())){
				login = usuarioManager.changePass(form.getUsername(), form.getPassword(), form.getNuevaPassword());
				if ( ! login){
					respuesta.setValido(false);
					respuesta.setCodError(ConstantsErrors.LOGIN_COD_1_COD_ERROR);
					respuesta.setError(ConstantsErrors.LOGIN_COD_1_ERROR);
					respuesta.setDescripcion("El usuario o clave ingresado no son válidos.");
				}
			} else {
				respuesta.setValido(false);
				respuesta.setCodError(ConstantsErrors.LOGIN_COD_2_COD_ERROR);
				respuesta.setError(ConstantsErrors.LOGIN_COD_2_ERROR);
				respuesta.setDescripcion("\'Nueva clave\' y \'repetir nueva clave\' deben ser iguales.");
			}
//		} else {
//			respuesta.setValido(false);
//			respuesta.setCodError(ConstantsErrors.LOGIN_COD_3_COD_ERROR);
//			respuesta.setError(ConstantsErrors.LOGIN_COD_3_ERROR);
//			respuesta.setDescripcion("Usuario Ingresado incorrecto, debe ser el mismo que se encuetra logueado");
//
//		}
		return respuesta;
	}
	
	
	
	
}
