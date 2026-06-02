package main.usercases;

import com.mirakuru.application.usecases.ConsultarAfectadoUseCase;
import com.mirakuru.domain.model.Afectado;
import com.mirakuru.domain.ports.AfectadoRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultarAfectadoService implements ConsultarAfectadoUseCase {

    private final AfectadoRepository repository;

    public ConsultarAfectadoService(
            AfectadoRepository repository) {

        this.repository = repository;
    }

    @Override
    public Afectado ejecutar(Long id) {

        return repository.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Afectado no encontrado"));
    }
}