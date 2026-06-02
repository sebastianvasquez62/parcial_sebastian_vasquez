package com.mirakuru.api.controller;

import com.mirakuru.api.dto.ActualizarAfectadoRequest;
import com.mirakuru.api.dto.AfectadoResponse;
import com.mirakuru.api.dto.RegistrarAfectadoRequest;
import com.mirakuru.application.dto.ActualizarAfectadoCommand;
import com.mirakuru.application.dto.RegistrarAfectadoCommand;
import com.mirakuru.application.usecases.ActualizarAfectadoUseCase;
import com.mirakuru.application.usecases.ConsultarAfectadoUseCase;
import com.mirakuru.application.usecases.ConsultarTodosAfectadosUseCase;
import com.mirakuru.application.usecases.RegistrarAfectadoUseCase;
import com.mirakuru.domain.model.Afectado;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/afectados")
public class AfectadoController {

    private final RegistrarAfectadoUseCase registrarUseCase;
    private final ConsultarAfectadoUseCase consultarUseCase;
    private final ConsultarTodosAfectadosUseCase consultarTodosUseCase;
    private final ActualizarAfectadoUseCase actualizarUseCase;

    public AfectadoController(
            RegistrarAfectadoUseCase registrarUseCase,
            ConsultarAfectadoUseCase consultarUseCase,
            ConsultarTodosAfectadosUseCase consultarTodosUseCase,
            ActualizarAfectadoUseCase actualizarUseCase) {

        this.registrarUseCase = registrarUseCase;
        this.consultarUseCase = consultarUseCase;
        this.consultarTodosUseCase = consultarTodosUseCase;
        this.actualizarUseCase = actualizarUseCase;
    }

    @PostMapping
    public ResponseEntity<AfectadoResponse> registrar(
            @Valid @RequestBody RegistrarAfectadoRequest request) {

        Afectado afectado = registrarUseCase.ejecutar(
                new RegistrarAfectadoCommand(
                        request.getNombre(),
                        request.getNivelAgresividad()
                )
        );

        URI location = URI.create("/api/afectados/" + afectado.getId());
        return ResponseEntity.created(location)
                .body(AfectadoResponse.from(afectado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AfectadoResponse> consultar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                AfectadoResponse.from(consultarUseCase.ejecutar(id))
        );
    }

    @GetMapping
    public ResponseEntity<List<AfectadoResponse>> listar() {
        return ResponseEntity.ok(
                consultarTodosUseCase.ejecutar()
                        .stream()
                        .map(AfectadoResponse::from)
                        .collect(Collectors.toList())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AfectadoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarAfectadoRequest request) {

        Afectado afectado = actualizarUseCase.ejecutar(
                id,
                new ActualizarAfectadoCommand(
                        request.getNombre(),
                        request.getNivelAgresividad()
                )
        );

        return ResponseEntity.ok(AfectadoResponse.from(afectado));
    }
}
