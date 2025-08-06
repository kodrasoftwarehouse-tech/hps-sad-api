package com.hps.vilanova.controller.response.paciente;

import com.hps.vilanova.controller.response.endereco.EnderecoResponse;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDetalheResponse {

    private Long id;
    private String nome;
    private int idade;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
    private String cpf;
    private String cid;
    private String telefone1;
    private String telefone2;
    private boolean status;

}
