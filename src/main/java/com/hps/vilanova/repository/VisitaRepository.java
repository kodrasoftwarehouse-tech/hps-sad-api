package com.hps.vilanova.repository;

import com.hps.vilanova.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
    List<Visita> findByEquipeId(Long equipeId);

    Optional<Visita> findByCorridaId(Long id);
}
