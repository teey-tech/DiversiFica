package com.generation.diversifica.utils;

/**
 * Enuns para ser utilizado no model Usuários
 *  
 *  @author Bruno Ribeiro Dutra
 *  @since 27/01/2022
 *  @version 1.0
 *  @see Usuário
 *  
 */
public enum TipoUsuario {
    PESSOA_FISICA("Pessoa Física"), PESSOA_JURIDICA("Pessoa Jurídica");
    private String tipo;

    private TipoUsuario(String tipo) {
        this.tipo = tipo;
    }
    public String tipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return this.tipo;
    }
}
