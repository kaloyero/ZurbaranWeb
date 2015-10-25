package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "opciones")
public class Opcion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Opcion() {
	}

	public Opcion(int id) {
		setId(id);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Codigo" , updatable=false)
	private String codigo;
	
	@Column(name = "familia", updatable=false)
	private String familia;

	@Column(name = "Nombre", updatable=false)
	private String nombre;
	
	@Column(name = "Descripcion", updatable=false)
	private String  descripcion;

	@Column(name = "Inactivo", updatable=false)
	private String  estado;

	@Column(name = "Orden", updatable=false)
	private int orden;

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	
}
