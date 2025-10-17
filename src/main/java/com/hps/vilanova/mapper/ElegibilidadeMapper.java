package com.hps.vilanova.mapper;

import com.hps.vilanova.dto.elegibilidade.ElegibilidadeRequest;
import com.hps.vilanova.dto.elegibilidade.ElegibilidadeResponse;
import com.hps.vilanova.dto.request.paciente.PacienteAdicionarRequest;
import com.hps.vilanova.model.Elegibilidade;
import com.hps.vilanova.model.Paciente;

import java.util.List;
import java.util.stream.Collectors;

public class ElegibilidadeMapper {

    public static ElegibilidadeResponse toResponse(Elegibilidade elegibilidade) {
        return ElegibilidadeResponse.builder()
                .id(elegibilidade.getId())
                .nome(elegibilidade.getNome())
                .nivel(elegibilidade.getNivel())
                .dataDeCriacao(elegibilidade.getDataDeCriacao())
                .paciente(toDTO(elegibilidade.getPaciente()))
                .build();
    }

    public static PacienteAdicionarRequest toDTO(Paciente paciente) {
        var elegibilidades = paciente.getElegibilidades().stream()
                .map(ElegibilidadeMapper::toSimpleDTO)
                .collect(Collectors.toList());

        return PacienteAdicionarRequest.builder()
                .nome(paciente.getNome())
                .idade(paciente.getIdade())
                .dataNascimento(paciente.getDataNascimento())
                .telefone1(paciente.getTelefone1())
                .telefone2(paciente.getTelefone2())
                .elegibilidades(elegibilidades)
                .build();
    }

    public static ElegibilidadeRequest toSimpleDTO(Elegibilidade elegibilidade) {
        return ElegibilidadeRequest.builder()
                .id(elegibilidade.getId())
                .nome(elegibilidade.getNome())
                .nivel(elegibilidade.getNivel())
                .dataDeCriacao(elegibilidade.getDataDeCriacao())
                .build();
    }
}
