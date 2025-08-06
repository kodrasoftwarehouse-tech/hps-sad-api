package com.hps.vilanova.controller.request.consultoria;

import com.hps.vilanova.model.enums.ModalidadeVisita;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultoriaModalidadeVisitaRequest {

    @NotNull
    private ModalidadeVisita modalidadeVisita;

}
