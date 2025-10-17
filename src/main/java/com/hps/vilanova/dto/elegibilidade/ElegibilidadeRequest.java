package com.hps.vilanova.dto.elegibilidade;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ElegibilidadeRequest {

    private Long id;
    private String nome;
    private String nivel;
    private LocalDateTime dataDeCriacao;
}
