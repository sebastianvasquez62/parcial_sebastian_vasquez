package main.dto;

public class RegistrarAfectadoRequest {

    private String nombre;
    private Integer nivelAgresividad;

    public RegistrarAfectadoRequest() {
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