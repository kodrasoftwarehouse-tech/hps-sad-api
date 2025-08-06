package com.hps.vilanova.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class RelatorioUsuarioId implements Serializable {
    private Long relatorioId;
    private Long usuarioId;

    public RelatorioUsuarioId(Long relatorioId, Long usuarioId) {
        this.relatorioId = relatorioId;
        this.usuarioId = usuarioId;
    }
}
