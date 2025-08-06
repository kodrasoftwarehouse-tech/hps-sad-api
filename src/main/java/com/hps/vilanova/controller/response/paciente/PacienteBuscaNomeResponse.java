package com.hps.vilanova.controller.response.paciente;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacienteBuscaNomeResponse {

    private Long id;

    private String nome;

}
