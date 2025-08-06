package com.hps.vilanova.repository;

import com.hps.vilanova.model.RelatorioUsuario;
import com.hps.vilanova.model.RelatorioUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioUsuarioRepository extends JpaRepository<RelatorioUsuario, RelatorioUsuarioId> {
}
