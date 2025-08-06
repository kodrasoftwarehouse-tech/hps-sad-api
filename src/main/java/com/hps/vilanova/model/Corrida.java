package com.hps.vilanova.model;


import com.hps.vilanova.model.enums.StatusCorrida;
import com.hps.vilanova.model.enums.TipoCorrida;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private BigDecimal kmInicial;
    private BigDecimal kmFinal;

    private LocalTime horaInicial;
    private LocalTime horaFinal;

    private LocalDate dataCorrida;

    @OneToOne
    @JoinColumn(name = "posicao_inicial_id")
    private Posicao posicaoInicial;

    @OneToOne
    @JoinColumn(name = "posicao_final_id")
    private Posicao posicaoFinal;

    @Enumerated(EnumType.STRING)
    private TipoCorrida tipoCorrida;

    @Enumerated(EnumType.STRING)
    private StatusCorrida statusCorrida;

    private String outrosDescricao;

    private String motivoCancelamento;

}
