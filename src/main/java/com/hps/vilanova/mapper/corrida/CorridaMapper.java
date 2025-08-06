package com.hps.vilanova.mapper.corrida;


import com.hps.vilanova.controller.request.corrida.CorridaCadastroRequest;
import com.hps.vilanova.controller.response.corrida.CorridaCadastroResponse;
import com.hps.vilanova.controller.response.corrida.CorridaResponse;
import com.hps.vilanova.mapper.usuario.UsuarioMapper;
import com.hps.vilanova.mapper.veiculo.VeiculoMapper;
import com.hps.vilanova.model.Corrida;
import com.hps.vilanova.model.Posicao;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.model.enums.StatusCorrida;
import jakarta.validation.Valid;

import java.time.LocalTime;

public class CorridaMapper {


    public static Corrida toEntity( CorridaCadastroRequest request, Posicao posicao,  Usuario usuario, Veiculo veiculo) {
        return Corrida.builder()
                .veiculo(veiculo)
                .usuario(usuario)
                .kmInicial(request.getKmInicial())
                .horaInicial(LocalTime.now())
                .posicaoInicial(posicao)
                .tipoCorrida(request.getTipoCorrida())
                .build();
    }

    public static CorridaCadastroResponse toResponse(Corrida corrida) {
        return CorridaCadastroResponse.builder()
                .id(corrida.getId())
                .build();
    }


    public static CorridaResponse toDetalheResponse(Corrida corrida) {

        return CorridaResponse.builder()
                .id(corrida.getId())
                .veiculo(VeiculoMapper.toResponse(corrida.getVeiculo()))
                .usuario(UsuarioMapper.toResponse(corrida.getUsuario()))
                .kmInicial(corrida.getKmInicial())
                .kmFinal(corrida.getKmFinal())
                .horaInicial(corrida.getHoraInicial())
                .horaFinal(corrida.getHoraFinal())
                .dataCorrida(corrida.getDataCorrida())
                .posicaoInicial(corrida.getPosicaoInicial())
                .posicaoFinal(corrida.getPosicaoFinal())
                .tipoCorrida(corrida.getTipoCorrida())
                .statusCorrida(corrida.getStatusCorrida())
                .outrosDescricao(corrida.getOutrosDescricao())
                .build();
    }
}
