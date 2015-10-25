package com.contable.form;

import com.contable.common.beans.FormConfig;

public class OpcionForm implements FormConfig  {
	private static final long serialVersionUID = 1L;

	public OpcionForm() {
	}

	public OpcionForm(int id) {
		setId(id);
	}
	private  int id ;
	
	private String codigo;
	
	private String familia;

	private String nombre;
	
	private String  descripcion;

	private String  estado;

	private int orden;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
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

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	
	
}
