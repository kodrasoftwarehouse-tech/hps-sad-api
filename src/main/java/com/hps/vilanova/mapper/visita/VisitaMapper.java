package com.hps.vilanova.mapper.visita;

import com.hps.vilanova.controller.request.visita.VisitaAgendarRequest;
import com.hps.vilanova.controller.response.visita.VisitaResponse;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.Visita;
import com.hps.vilanova.model.enums.StatusVisita;

import java.time.LocalTime;

public class VisitaMapper {
    public static Visita toAgendarVisita(Paciente paciente, Usuario usuario, Equipe equipe, VisitaAgendarRequest request) {
        return Visita.builder()
                .paciente(paciente)
                .usuario(usuario)
                .equipe(equipe)
                .classificacao(request.getClassificacao())
                .statusVisita(request.getStatusVisita())
                .build();
    }

    public static VisitaResponse toVisitaResponse(Visita visita){
        return VisitaResponse.builder()
                .id(visita.getId())
                .paciente(visita.getPaciente())
                .corrida(visita.getCorrida())
                .usuario(visita.getUsuario())
                .equipe(visita.getEquipe())
                .relatorio(visita.getRelatorio())
                .horaInicial(visita.getHoraInicial())
                .horaFinal(visita.getHoraFinal())
                .classificacao(visita.getClassificacao())
                .statusVisita(visita.getStatusVisita())
                .build();
    }
}
