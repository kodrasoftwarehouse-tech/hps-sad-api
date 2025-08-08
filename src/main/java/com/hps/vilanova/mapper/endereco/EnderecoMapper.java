package com.hps.vilanova.mapper.endereco;


import com.hps.vilanova.dto.request.endereco.EnderecoRequest;
import com.hps.vilanova.dto.response.endereco.EnderecoResponse;
import com.hps.vilanova.model.Endereco;


public class EnderecoMapper {
    public static Endereco toEntity(EnderecoRequest request) {
        return Endereco.builder()
                .logradouro(request.getLogradouro())
                .complemento(request.getComplemento())
                .numero(request.getNumero())
                .bairro(request.getBairro())
                .cidade(request.getCidade())
                .estado(request.getEstado())
                .cep(request.getCep())
                .build();
    }

    public static EnderecoResponse toResponse(Endereco endereco) {
        return EnderecoResponse.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }
}
