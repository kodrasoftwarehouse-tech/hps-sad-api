package com.hps.vilanova.controller.request.relatorio;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioUsuarioRequest {

    @NotNull
    private Long usuarioId;
}
