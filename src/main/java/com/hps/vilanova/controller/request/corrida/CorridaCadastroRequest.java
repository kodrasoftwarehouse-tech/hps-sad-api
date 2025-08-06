package com.hps.vilanova.controller.request.corrida;

import com.hps.vilanova.model.Posicao;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.model.enums.TipoCorrida;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class CorridaCadastroRequest {

    @NotNull
    private Long veiculoId;
    @NotNull
    private Long usuarioId;
    @NotNull
    private BigDecimal kmInicial;
    @NotNull
    private Posicao posicaoInicial;
    @NotNull
    private TipoCorrida tipoCorrida;

    private String outrosDescricao;

}
