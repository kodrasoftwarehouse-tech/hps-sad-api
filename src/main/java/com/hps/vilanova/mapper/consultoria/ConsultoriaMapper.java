package com.hps.vilanova.mapper.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.controller.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.mapper.usuario.UsuarioMapper;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.enums.StatusSala;
import jakarta.validation.Valid;

import java.time.LocalTime;

public class ConsultoriaMapper {


    public static Consultoria toEntity(@Valid ConsultoriaRequest request, Usuario usuario, Paciente paciente, Equipe equipe) {

        return Consultoria.builder()
                .paciente(paciente)
                .usuario(usuario)
                .equipe(equipe)
                .unidadeSaude(request.getUnidadeSaude())
                .dataConsultoria(request.getDataConsultoria())
                .solicitante(request.getSolicitante())
                .hora(LocalTime.now())
                .statusConsultoria(paciente.isStatus())
                .statusSala(StatusSala.AGUARDANDO_CONTATO)
                .build();
    }


    public static ConsultoriaResponse toResponse(Consultoria consultoria) {
        return ConsultoriaResponse.builder()
                .id(consultoria.getId())
                .paciente(consultoria.getPaciente())
                .usuario(UsuarioMapper.toResponse(consultoria.getUsuario()))
                .equipe(consultoria.getEquipe())
                .unidadeSaude(consultoria.getUnidadeSaude())
                .dataConsultoria(consultoria.getDataConsultoria())
                .solicitante(consultoria.getSolicitante())
                .hora(consultoria.getHora())
                .statusBaixa(consultoria.getStatusBaixa())
                .modalidadeVisita(consultoria.getModalidadeVisita())
                .statusSala(consultoria.getStatusSala())
                .statusConsultoria(consultoria.isStatusConsultoria())
                .situacoesEspecificas(consultoria.getSituacoesEspecificas())
                .hospital(consultoria.getHospital())
                .build();
    }
}
