package com.hps.vilanova.controller.response.corrida;

import com.hps.vilanova.controller.response.usuario.UsuarioResponse;
import com.hps.vilanova.controller.response.veiculo.VeiculoResponse;
import com.hps.vilanova.model.Posicao;
import com.hps.vilanova.model.enums.StatusCorrida;
import com.hps.vilanova.model.enums.TipoCorrida;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class CorridaResponse {

    private Long id;

    private VeiculoResponse veiculo;

    private UsuarioResponse usuario;

    private BigDecimal kmInicial;

    private BigDecimal kmFinal;

    private LocalTime horaInicial;

    private LocalTime horaFinal;

    private LocalDate dataCorrida;

    private Posicao posicaoInicial;

    private Posicao posicaoFinal;

    private TipoCorrida tipoCorrida;

    private StatusCorrida statusCorrida;

    private String outrosDescricao;

}
