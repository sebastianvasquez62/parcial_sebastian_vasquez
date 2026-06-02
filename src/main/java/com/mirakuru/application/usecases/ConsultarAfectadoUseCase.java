package com.mirakuru.application.usecases;

import com.mirakuru.domain.model.Afectado;

public interface ConsultarAfectadoUseCase {

    Afectado ejecutar(Long id);
}
