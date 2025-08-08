package com.hps.vilanova.repository;

import com.hps.vilanova.dto.response.paciente.PacienteBuscaNomeResponse;
import com.hps.vilanova.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT new com.hps.vilanova.controller.response.paciente.PacienteBuscaNomeResponse(p.id, p.nome) " +
            "FROM Paciente p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :texto, '%'))")
    Page<PacienteBuscaNomeResponse> search(@Param("texto") String texto, Pageable pageable);

    @Query("SELECT new com.hps.vilanova.controller.response.paciente.PacienteBuscaNomeResponse(p.id, p.nome) FROM Paciente p")
    Page<PacienteBuscaNomeResponse> findAllPacientes(Pageable pageable);
}
