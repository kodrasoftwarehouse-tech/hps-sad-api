package com.hps.vilanova.controller.request.consultoria;

import com.hps.vilanova.model.enums.ModalidadeVisita;
import com.hps.vilanova.model.enums.StatusBaixa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultoriaEditarRequest {


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

    private StatusBaixa statusBaixa;

    private ModalidadeVisita modalidadeVisita;

}
