package com.mirakuru.application.usecases;

import com.mirakuru.domain.model.Afectado;

import java.util.List;

public interface ConsultarTodosAfectadosUseCase {

    List<Afectado> ejecutar();
}
