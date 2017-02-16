package com.contable.common.constants;

public enum AuditoriaTipo {

	NUEVO("NUEVO","Se creo el documento"),
	ANULADO("ANULADO","Se anulo el documento"),
	ANULADOR("ANULADOR","Se creo el Documento anulador"),
	ELIMINADO("ELIMINADO","Se creo el documento");
	
    private String valor; 
    private String label;
    
    AuditoriaTipo (String valor,String label){
    	this.valor = valor;
    	this.label = label;
    }
    
    public String getDescription() {
        return getClass().getName() + "." + name();
    }

    @Override
    public String toString() {
        return getDescription();
    }

	public String getvalor() {
		return valor;
	}

	public String getLabel() {
		return label;
	} 
	
	
}
