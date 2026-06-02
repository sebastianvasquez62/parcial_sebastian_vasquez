package main.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAfectadoRepository
        extends JpaRepository<AfectadoEntity, Long> {
}