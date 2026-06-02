package main;

import com.mirakuru.api.dto.ActualizarAfectadoRequest;
import com.mirakuru.api.dto.RegistrarAfectadoRequest;
import com.mirakuru.application.dto.ActualizarAfectadoCommand;
import com.mirakuru.application.dto.RegistrarAfectadoCommand;
import com.mirakuru.application.usecases.ActualizarAfectadoUseCase;
import com.mirakuru.application.usecases.ConsultarAfectadoUseCase;
import com.mirakuru.application.usecases.ConsultarTodosAfectadosUseCase;
import com.mirakuru.application.usecases.RegistrarAfectadoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> registrar(
            @RequestBody RegistrarAfectadoRequest request) {

        return ResponseEntity.ok(
                registrarUseCase.ejecutar(
                        new RegistrarAfectadoCommand(
                                request.getNombre(),
                                request.getNivelAgresividad()
                        )
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                consultarUseCase.ejecutar(id)
        );
    }

    @GetMapping
    public ResponseEntity<?> listar() {

        return ResponseEntity.ok(
                consultarTodosUseCase.ejecutar()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarAfectadoRequest request) {

        return ResponseEntity.ok(
                actualizarUseCase.ejecutar(
                        id,
                        new ActualizarAfectadoCommand(
                                request.getNombre(),
                                request.getNivelAgresividad()
                        )
                )
        );
    }
}