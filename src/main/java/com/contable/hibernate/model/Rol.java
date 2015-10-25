package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Rol() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Descripcion")
	private String  descripcion;

	@Column(name = "Inactivo")
	private String  estado;
	
//	@Cascade(value= CascadeType.ALL)
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rolopcion")
//	@Fetch(FetchMode.SUBSELECT)
//	@OrderBy("idRole")
//	private List<Opcion> acceso_opciones = new LinkedList<Opcion>();

	@Cascade(value= { CascadeType.ALL})
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rolopciones",  joinColumns = { 
			@JoinColumn(name = "IdRole", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "IdOpcion", 
					nullable = false, updatable = false) })
	private List<Opcion> accesoOciones = new LinkedList<Opcion>();
	
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

	public List<Opcion> getAccesoOciones() {
		return accesoOciones;
	}

	public void setAccesoOciones(List<Opcion> accesoOciones) {
		this.accesoOciones = accesoOciones;
	}


	

}
