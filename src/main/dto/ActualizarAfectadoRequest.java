package main.dto;

public class ActualizarAfectadoRequest {

    private String nombre;
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