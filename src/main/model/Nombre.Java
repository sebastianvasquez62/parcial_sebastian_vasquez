package com.mirakuru.domain.model;

public class Nombre {

    private final String valor;

    public Nombre(String valor) {

        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }

        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}