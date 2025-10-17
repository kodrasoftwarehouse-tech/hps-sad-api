package com.hps.vilanova.dto.elegibilidade;

import com.hps.vilanova.dto.request.paciente.PacienteAdicionarRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ElegibilidadeResponse {

    private Long id;
    private String nome;
    private String nivel;
    private LocalDateTime dataDeCriacao;
    private PacienteAdicionarRequest paciente;
}
