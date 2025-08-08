package com.hps.vilanova.dto.request.corrida;


import com.hps.vilanova.model.Posicao;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CorridaFinalizarRequest {

    @NotNull
    private BigDecimal kmFinal;

    @NotNull
    private Posicao posicaoFinal;

}
