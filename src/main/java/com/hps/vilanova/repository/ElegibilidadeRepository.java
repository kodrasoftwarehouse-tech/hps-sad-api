package com.hps.vilanova.repository;

import com.hps.vilanova.model.Elegibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElegibilidadeRepository extends JpaRepository<Elegibilidade, Long> {
    List<Elegibilidade> findByPacienteIdOrderByDataDeCriacaoDesc(Long id);
}
