package com.robo.ancora.guilherme.entities.enums;

public enum Situacao {

	ATIVO("ATIVO"),
	INATIVO("INATIVO");
	
	
 private final String status;
    
   Situacao(String status) {
        this.status = status;
    }
    
    public String getNome() {
        return status;
    }
}
