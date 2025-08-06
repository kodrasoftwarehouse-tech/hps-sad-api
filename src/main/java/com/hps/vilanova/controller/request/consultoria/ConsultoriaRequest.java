package com.hps.vilanova.controller.request.consultoria;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultoriaRequest {

    @NotNull
    private Long pacienteId;

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long equipeId;

    @NotBlank
    private String unidadeSaude;
    @NotNull
    private LocalDate dataConsultoria;
    @NotNull
    private String solicitante;

}
