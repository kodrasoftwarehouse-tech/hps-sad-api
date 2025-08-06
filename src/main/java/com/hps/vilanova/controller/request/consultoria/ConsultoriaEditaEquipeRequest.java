package com.hps.vilanova.controller.request.consultoria;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsultoriaEditaEquipeRequest {

    @NotNull
    private Long equipeId;
}
