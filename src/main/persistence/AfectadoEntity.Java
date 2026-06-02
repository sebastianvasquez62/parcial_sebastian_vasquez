package com.mirakuru.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "afectados")
public class AfectadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String nivelAmenaza;

    private String estadoMirakuru;

    private Integer nivelAgresividad;

    public AfectadoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelAmenaza() {
        return nivelAmenaza;
    }

    public void setNivelAmenaza(String nivelAmenaza) {
        this.nivelAmenaza = nivelAmenaza;
    }

    public String getEstadoMirakuru() {
        return estadoMirakuru;
    }

    public void setEstadoMirakuru(String estadoMirakuru) {
        this.estadoMirakuru = estadoMirakuru;
    }

    public Integer getNivelAgresividad() {
        return nivelAgresividad;
    }

    public void setNivelAgresividad(Integer nivelAgresividad) {
        this.nivelAgresividad = nivelAgresividad;
    }
}