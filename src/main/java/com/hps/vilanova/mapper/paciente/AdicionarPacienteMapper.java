package com.hps.vilanova.mapper.paciente;

import com.hps.vilanova.controller.request.paciente.PacienteAdicionarRequest;
import com.hps.vilanova.controller.response.paciente.PacienteAdicionarReponse;
import com.hps.vilanova.model.Endereco;
import com.hps.vilanova.model.Paciente;


public class AdicionarPacienteMapper {
    public static Paciente toEntity(PacienteAdicionarRequest request, Endereco endereco) {
      return  Paciente.builder()
                .nome(request.getNome())
                .idade(request.getIdade())
                .dataNascimento(request.getDataNascimento())
                .endereco(endereco)
                .telefone1(request.getTelefone1())
                .telefone2(request.getTelefone2())
                .status(true)
                .build();

    }

    public static PacienteAdicionarReponse toResponse(Paciente paciente) {

        PacienteAdicionarReponse response = new PacienteAdicionarReponse();
        response.setId(paciente.getId());
        return response;
    }
}
