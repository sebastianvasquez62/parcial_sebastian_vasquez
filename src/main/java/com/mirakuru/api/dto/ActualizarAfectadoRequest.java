package com.mirakuru.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ActualizarAfectadoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El nivel de agresividad es obligatorio")
    @Min(value = 0, message = "La agresividad mínima es 0")
    @Max(value = 100, message = "La agresividad máxima es 100")
    private Integer nivelAgresividad;

    public ActualizarAfectadoRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivelAgresividad() {
        return nivelAgresividad;
    }

    public void setNivelAgresividad(Integer nivelAgresividad) {
        this.nivelAgresividad = nivelAgresividad;
    }
}
