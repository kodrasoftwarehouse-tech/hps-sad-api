package com.hps.vilanova.controller.request.visita;


import com.hps.vilanova.model.enums.ClassificacaoVisita;
import com.hps.vilanova.model.enums.StatusVisita;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitaAgendarRequest {

    @NotNull
    private Long usuarioId;
    @NotNull
    private Long equipeId;
    @NotNull
    private ClassificacaoVisita classificacao;
    @NotNull
    private StatusVisita statusVisita;

}
