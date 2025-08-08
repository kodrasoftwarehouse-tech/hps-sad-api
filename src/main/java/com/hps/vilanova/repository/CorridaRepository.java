package com.hps.vilanova.repository;

import com.hps.vilanova.model.Corrida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {
    Page<Corrida> findByVeiculoIdAndDataCorridaBetween(Long veiculoId, LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);

    Page<Corrida> findByVeiculoId(Long veiculoId, Pageable pageable);
}
