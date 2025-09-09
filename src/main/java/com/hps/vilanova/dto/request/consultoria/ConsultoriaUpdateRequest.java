package com.hps.vilanova.dto.request.consultoria;

import com.hps.vilanova.model.enums.ModalidadeVisita;
import com.hps.vilanova.model.enums.StatusBaixa;
import com.hps.vilanova.model.enums.StatusSala;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultoriaUpdateRequest {
    @NotNull
    private Long id;  // obrigatório para atualizar

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
    @NotNull
    private StatusSala statusSala;
    @NotNull
    private StatusBaixa statusBaixa;
    @NotNull
    private ModalidadeVisita modalidadeVisita;
    private String hospital;
    private String situacoesEspecificas;
}
