package com.mirakuru.application.services;

import com.mirakuru.application.dto.ActualizarAfectadoCommand;
import com.mirakuru.application.exception.NotFoundException;
import com.mirakuru.application.usecases.ActualizarAfectadoUseCase;
import com.mirakuru.domain.model.Afectado;
import com.mirakuru.domain.model.NivelAmenaza;
import com.mirakuru.domain.ports.AfectadoRepository;
import com.mirakuru.domain.service.ClasificadorAmenazaService;
import org.springframework.stereotype.Service;

@Service
public class ActualizarAfectadoService implements ActualizarAfectadoUseCase {

    private final AfectadoRepository repository;
    private final ClasificadorAmenazaService clasificador;

    public ActualizarAfectadoService(
            AfectadoRepository repository,
            ClasificadorAmenazaService clasificador) {

        this.repository = repository;
        this.clasificador = clasificador;
    }

    @Override
    public Afectado ejecutar(Long id, ActualizarAfectadoCommand command) {

        Afectado afectado = repository.buscarPorId(id)
                .orElseThrow(() -> new NotFoundException("Afectado no encontrado"));

        NivelAmenaza nuevaAmenaza = clasificador.clasificar(command.nivelAgresividad());
        afectado.actualizarAgresividad(command.nivelAgresividad(), nuevaAmenaza);

        return repository.guardar(afectado);
    }
}
