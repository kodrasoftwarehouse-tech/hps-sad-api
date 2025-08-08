package com.hps.vilanova.dto.request.paciente;

import com.hps.vilanova.dto.request.endereco.EnderecoRequest;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteEditarRequest {

    private String nome;
    private int idade;
    private LocalDate dataNascimento;
    private EnderecoRequest endereco;
    private String cpf;
    private String cid;
    private String telefone1;
    private String telefone2;
    private Boolean status;

}
