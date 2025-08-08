package com.hps.vilanova.dto.request.corrida;

import com.hps.vilanova.model.Posicao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CorridaCancelarRequest {

    private BigDecimal kmFinal;

    private String motivoCancelamento;

    private Posicao posicaoFinal;

}
