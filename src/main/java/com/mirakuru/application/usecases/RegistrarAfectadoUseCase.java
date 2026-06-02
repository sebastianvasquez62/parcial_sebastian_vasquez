package com.mirakuru.application.usecases;

import com.mirakuru.application.dto.RegistrarAfectadoCommand;
import com.mirakuru.domain.model.Afectado;

public interface RegistrarAfectadoUseCase {

    Afectado ejecutar(RegistrarAfectadoCommand command);
}
