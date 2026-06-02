package main.usercases;

import com.mirakuru.application.usecases.ConsultarTodosAfectadosUseCase;
import com.mirakuru.domain.model.Afectado;
import com.mirakuru.domain.ports.AfectadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarTodosAfectadosService
        implements ConsultarTodosAfectadosUseCase {

    private final AfectadoRepository repository;

    public ConsultarTodosAfectadosService(
            AfectadoRepository repository) {

        this.repository = repository;
    }

    @Override
    public List<Afectado> ejecutar() {
        return repository.buscarTodos();
    }
}