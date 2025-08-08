package com.hps.vilanova.dto.request.relatorio;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioUsuarioRequest {

    @NotNull
    private Long usuarioId;
}
