package com.mirakuru.infrastructure.persistence;

import com.mirakuru.domain.model.Afectado;
import com.mirakuru.domain.model.EstadoMirakuru;
import com.mirakuru.domain.model.Nombre;
import com.mirakuru.domain.model.NivelAmenaza;
import com.mirakuru.domain.ports.AfectadoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaAfectadoRepository implements AfectadoRepository {

    private final SpringDataAfectadoRepository repository;

    public JpaAfectadoRepository(SpringDataAfectadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Afectado guardar(Afectado afectado) {
        AfectadoEntity entity = new AfectadoEntity();
        entity.setId(afectado.getId());
        entity.setNombre(afectado.getNombre().getValor());
        entity.setNivelAmenaza(afectado.getNivelAmenaza().name());
        entity.setEstadoMirakuru(afectado.getEstadoMirakuru().name());
        entity.setNivelAgresividad(afectado.getNivelAgresividad());

        entity = repository.save(entity);
        return convertir(entity);
    }

    @Override
    public Optional<Afectado> buscarPorId(Long id) {
        return repository.findById(id).map(this::convertir);
    }

    @Override
    public List<Afectado> buscarTodos() {
        return repository.findAll().stream().map(this::convertir).toList();
    }

    private Afectado convertir(AfectadoEntity entity) {
        return new Afectado(
                entity.getId(),
                new Nombre(entity.getNombre()),
                NivelAmenaza.valueOf(entity.getNivelAmenaza()),
                EstadoMirakuru.valueOf(entity.getEstadoMirakuru()),
                entity.getNivelAgresividad()
        );
    }
}
