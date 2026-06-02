package com.mirakuru.application.usecases;

import com.mirakuru.application.dto.ActualizarAfectadoCommand;
import com.mirakuru.domain.model.Afectado;

public interface ActualizarAfectadoUseCase {

    Afectado ejecutar(Long id, ActualizarAfectadoCommand command);
}
