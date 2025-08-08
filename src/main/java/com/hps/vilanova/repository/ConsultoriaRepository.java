package com.hps.vilanova.repository;

import com.hps.vilanova.model.Consultoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultoriaRepository extends JpaRepository<Consultoria, Long> {
    Page<Consultoria> findByStatusConsultoriaFalse(Pageable pageable);

    List<Consultoria> findByEquipeId(Long equipeId);
}
