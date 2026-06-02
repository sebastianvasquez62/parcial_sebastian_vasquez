package com.mirakuru.application.dto;

public record RegistrarAfectadoCommand(
        String nombre,
        Integer nivelAgresividad) {
}
