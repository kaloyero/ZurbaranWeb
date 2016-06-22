package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documentomovimientoscotizaciones")
public class DocumentoMovimientoCotizacion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoMovimientoCotizacion() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "IdMoneda")
    private  int monedaId;

	@Column(name = "IdDocumento")
	private int documentoId;
	
	@Column(name = "Cotizacion")
	private Double cotizacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(int monedaId) {
		this.monedaId = monedaId;
	}

	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}

	public Double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}

	@Override
	public DocumentoMovimientoCotizacion clone()  {
		DocumentoMovimientoCotizacion cotizacion = new DocumentoMovimientoCotizacion();
		cotizacion.setCotizacion(this.getCotizacion());
		cotizacion.setMonedaId(this.getMonedaId());
		cotizacion.setDocumentoId(this.getDocumentoId());
		
		return cotizacion;
	}



	
	
}
