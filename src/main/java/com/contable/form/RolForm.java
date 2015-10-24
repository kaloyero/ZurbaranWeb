package com.contable.form;

import java.util.List;

import com.contable.common.beans.FormConfig;

public class RolForm implements FormConfig  {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private List<Integer> idsOpciones;
	private String estado;
	
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
	public List<Integer> getIdsOpciones() {
		return idsOpciones;
	}
	public void setIdsOpciones(List<Integer> idsOpciones) {
		this.idsOpciones = idsOpciones;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
