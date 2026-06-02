package com.mirakuru.domain.ports;

import com.mirakuru.domain.model.Afectado;

import java.util.List;
import java.util.Optional;

public interface AfectadoRepository {

    Afectado guardar(Afectado afectado);

    Optional<Afectado> buscarPorId(Long id);

    List<Afectado> buscarTodos();
}
