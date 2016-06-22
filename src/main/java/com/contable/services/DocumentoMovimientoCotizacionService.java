package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.DocumentoMovimientoCotizacion;

public interface DocumentoMovimientoCotizacionService extends AbstractService<DocumentoMovimientoCotizacion>{
	
	List<DocumentoMovimientoCotizacion> getCotizacionesByIdDocumento(int idDocumento);

}
