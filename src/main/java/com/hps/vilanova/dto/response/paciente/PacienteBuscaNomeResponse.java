package com.hps.vilanova.dto.response.paciente;

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
