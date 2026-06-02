package com.mirakuru.api.dto;

import com.mirakuru.domain.model.Afectado;

public record AfectadoResponse(
        Long id,
        String nombre,
        String nivelAmenaza,
        String estadoMirakuru,
        Integer nivelAgresividad) {

    public static AfectadoResponse from(Afectado afectado) {
        return new AfectadoResponse(
                afectado.getId(),
                afectado.getNombre().getValor(),
                afectado.getNivelAmenaza().name(),
                afectado.getEstadoMirakuru().name(),
                afectado.getNivelAgresividad()
        );
    }
}
