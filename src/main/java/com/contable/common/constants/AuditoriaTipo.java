package com.contable.common.constants;

public enum AuditoriaTipo {

	N("N","Se creo el documento"),
	A("A","Se anulo el documento"),
	Z("Z","Se creo el Documento anulador"),
	E("E","Se elimino el documento");
	
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
