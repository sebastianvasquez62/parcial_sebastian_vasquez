package main.usercases;

import com.mirakuru.application.dto.ActualizarAfectadoCommand;
import com.mirakuru.application.usecases.ActualizarAfectadoUseCase;
import com.mirakuru.domain.model.*;
import com.mirakuru.domain.ports.AfectadoRepository;
import com.mirakuru.domain.service.ClasificadorAmenazaService;
import org.springframework.stereotype.Service;

@Service
public class ActualizarAfectadoService
        implements ActualizarAfectadoUseCase {

    private final AfectadoRepository repository;
    private final ClasificadorAmenazaService clasificador;

    public ActualizarAfectadoService(
            AfectadoRepository repository) {

        this.repository = repository;
        this.clasificador = new ClasificadorAmenazaService();
    }

    @Override
    public Afectado ejecutar(
            Long id,
            ActualizarAfectadoCommand command) {

        Afectado afectado =
                repository.buscarPorId(id)
                        .orElseThrow(() ->
                                new RuntimeException("Afectado no encontrado"));

        NivelAmenaza nuevaAmenaza =
                clasificador.clasificar(
                        command.nivelAgresividad());

        afectado.actualizarAgresividad(
                command.nivelAgresividad(),
                nuevaAmenaza);

        return repository.guardar(afectado);
    }
}