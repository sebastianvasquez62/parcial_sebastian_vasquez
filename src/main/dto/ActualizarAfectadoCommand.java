package main.dto;

public record ActualizarAfectadoCommand(
        String nombre,
        Integer nivelAgresividad) {
}