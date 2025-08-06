package com.hps.vilanova.controller.request.consultoria;

import com.hps.vilanova.model.enums.StatusBaixa;
import com.hps.vilanova.model.enums.StatusSala;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultoriaBaixaRequest {

    @NotNull
    private StatusSala statusSala;
    @NotNull
    private StatusBaixa statusBaixa;

}
