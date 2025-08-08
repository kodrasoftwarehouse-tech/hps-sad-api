package com.hps.vilanova.dto.request.paciente;

import com.hps.vilanova.dto.request.endereco.EnderecoRequest;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacienteAdicionarRequest {

    @NotNull
    private String nome;

    @NotNull
    private int idade;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private EnderecoRequest endereco;

    @NotNull
    private String telefone1;

    @NotNull
    private String telefone2;


}
