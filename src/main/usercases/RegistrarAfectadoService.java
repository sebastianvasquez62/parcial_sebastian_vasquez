package main.usercases;

import com.mirakuru.application.dto.RegistrarAfectadoCommand;
import com.mirakuru.application.usecases.RegistrarAfectadoUseCase;
import com.mirakuru.domain.model.*;
import com.mirakuru.domain.ports.AfectadoRepository;
import com.mirakuru.domain.service.ClasificadorAmenazaService;
import org.springframework.stereotype.Service;

@Service
public class RegistrarAfectadoService implements RegistrarAfectadoUseCase {

    private final AfectadoRepository repository;
    private final ClasificadorAmenazaService clasificador;

    public RegistrarAfectadoService(
            AfectadoRepository repository) {

        this.repository = repository;
        this.clasificador = new ClasificadorAmenazaService();
    }

    @Override
    public Afectado ejecutar(RegistrarAfectadoCommand command) {

        NivelAmenaza amenaza =
                clasificador.clasificar(command.nivelAgresividad());

        Afectado afectado = new Afectado(
                null,
                new Nombre(command.nombre()),
                amenaza,
                EstadoMirakuru.ACTIVO,
                command.nivelAgresividad()
        );

        return repository.guardar(afectado);
    }
}