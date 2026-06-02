package com.mirakuru.domain.model;

public class Afectado {

    private Long id;
    private Nombre nombre;
    private NivelAmenaza nivelAmenaza;
    private EstadoMirakuru estadoMirakuru;
    private Integer nivelAgresividad;

    public Afectado(
            Long id,
            Nombre nombre,
            NivelAmenaza nivelAmenaza,
            EstadoMirakuru estadoMirakuru,
            Integer nivelAgresividad) {

        this.id = id;
        this.nombre = nombre;
        this.nivelAmenaza = nivelAmenaza;
        this.estadoMirakuru = estadoMirakuru;
        this.nivelAgresividad = nivelAgresividad;
    }

    public Long getId() { return id; }

    public Nombre getNombre() { return nombre; }

    public NivelAmenaza getNivelAmenaza() { return nivelAmenaza; }

    public EstadoMirakuru getEstadoMirakuru() { return estadoMirakuru; }

    public Integer getNivelAgresividad() { return nivelAgresividad; }

    public void actualizarAgresividad(
            Integer nuevaAgresividad,
            NivelAmenaza nuevaAmenaza){

        this.nivelAgresividad = nuevaAgresividad;
        this.nivelAmenaza = nuevaAmenaza;
    }
}