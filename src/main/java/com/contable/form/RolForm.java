package com.contable.form;

import java.util.ArrayList;
import java.util.Collection;

import com.contable.common.beans.FormConfig;

public class RolForm implements FormConfig  {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private Collection<Integer> opcionesTodas;	
	private Collection<Integer> opcionesSeleccionadas;
	private Collection<OpcionForm> opcionesSeleccionadasTodo;
	private String estado;
	
	public RolForm() {
		opcionesTodas = new ArrayList<Integer>();	
		opcionesSeleccionadas = new ArrayList<Integer>();
		opcionesSeleccionadasTodo = new ArrayList<OpcionForm>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Collection<Integer> getOpcionesTodas() {
		return opcionesTodas;
	}
	public void setOpcionesTodas(Collection<Integer> opcionesTodas) {
		this.opcionesTodas = opcionesTodas;
	}
	public Collection<Integer> getOpcionesSeleccionadas() {
		return opcionesSeleccionadas;
	}
	public void setOpcionesSeleccionadas(Collection<Integer> opcionesSeleccionadas) {
		this.opcionesSeleccionadas = opcionesSeleccionadas;
	}
	public Collection<OpcionForm> getOpcionesSeleccionadasTodo() {
		return opcionesSeleccionadasTodo;
	}
	public void setOpcionesSeleccionadasTodo(
			Collection<OpcionForm> opcionesSeleccionadasTodo) {
		this.opcionesSeleccionadasTodo = opcionesSeleccionadasTodo;
	}

	
	
}
