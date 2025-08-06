package com.hps.vilanova.mapper.paciente;

import com.hps.vilanova.controller.response.endereco.EnderecoResponse;
import com.hps.vilanova.controller.response.paciente.PacienteDetalheResponse;
import com.hps.vilanova.mapper.endereco.EnderecoMapper;
import com.hps.vilanova.model.Endereco;
import com.hps.vilanova.model.Paciente;

public class PacienteDetalheMapper {


    public static PacienteDetalheResponse toResponse(Paciente paciente, Endereco endereco) {

        return PacienteDetalheResponse.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .idade(paciente.getIdade())
                .dataNascimento(paciente.getDataNascimento())
                .endereco(EnderecoMapper.toResponse(endereco))
                .cpf(paciente.getCpf())
                .cid(paciente.getCid())
                .telefone1(paciente.getTelefone1())
                .telefone2(paciente.getTelefone2())
                .status(paciente.isStatus())
                .build();



    }
}
