package com.contable.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.contable.common.constants.AuditoriaTipo;
import com.contable.common.utils.DateUtil;

@Entity
@Table(name = "auditoria")
public class Auditoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "idDocumento")
	private Integer idDocumento;
	
	@Column(name = "NroDocumento")
	private String nroDocumento;
	
	@Column(name = "accion")
	@Enumerated(EnumType.STRING)
	private AuditoriaTipo accion;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdUsuario")		
	private Usuario usuario;
	
	@Column(name = "Fecha")
	private Date date;
	
	@Transient
	private String dateToShow;
	
	public Auditoria() {
		super();
	}
	
	public Auditoria(Integer idDocumento, String nroDocumento,
			AuditoriaTipo nuevo, Integer usuario, Date date) {
		super();
		this.idDocumento = idDocumento;
		this.nroDocumento = nroDocumento;
		this.accion = nuevo;
		Usuario user = new Usuario();
		user.setId(usuario);
		this.usuario = user;
		this.date = date;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public AuditoriaTipo getAccion() {
		return accion;
	}

	public void setAccion(AuditoriaTipo accion) {
		this.accion = accion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDateToShow() {
		return DateUtil.convertDateToStringWithHour(date);
	}
	
	
	
}
