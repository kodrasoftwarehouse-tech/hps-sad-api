package com.hps.vilanova.dto.response.consultoria;

import com.hps.vilanova.dto.response.usuario.UsuarioResponse;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.model.enums.ModalidadeVisita;
import com.hps.vilanova.model.enums.StatusBaixa;
import com.hps.vilanova.model.enums.StatusSala;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultoriaResponse {
    private Long id;
    private Paciente paciente;
    private UsuarioResponse usuario;
    private Equipe equipe;
    private String unidadeSaude;
    private LocalDate dataConsultoria;
    private String solicitante;
    private LocalTime hora;
    private StatusBaixa statusBaixa;
    private ModalidadeVisita modalidadeVisita;
    private StatusSala statusSala;
    private boolean statusConsultoria;
    private String situacoesEspecificas;
    private String hospital;

}
