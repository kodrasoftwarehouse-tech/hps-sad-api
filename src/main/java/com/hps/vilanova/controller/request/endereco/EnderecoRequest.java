package com.hps.vilanova.controller.request.endereco;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequest {

    @NotNull
    private String logradouro;

    @NotNull
    private String complemento;

    @NotNull
    private String numero;

    @NotNull
    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;


    private String cep;
}
