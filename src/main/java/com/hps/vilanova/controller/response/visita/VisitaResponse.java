package com.hps.vilanova.controller.response.visita;

import com.hps.vilanova.model.*;
import com.hps.vilanova.model.enums.ClassificacaoVisita;
import com.hps.vilanova.model.enums.StatusVisita;
import lombok.*;

import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisitaResponse {

    private Long id;

    private Paciente paciente;

    private Corrida corrida;

    private Usuario usuario;

    private Equipe equipe;

    private Relatorio relatorio;

    private LocalTime horaInicial;

    private LocalTime horaFinal;

    private ClassificacaoVisita classificacao;

    private StatusVisita statusVisita;

}
