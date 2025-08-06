package com.hps.vilanova.controller.request.consultoria;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultoriaVisitaAgendadaRequest {

    @NotNull
    private Long usuarioId;
    @NotNull
    private Long equipeId;

}
