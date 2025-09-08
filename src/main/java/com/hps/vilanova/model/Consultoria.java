package com.hps.vilanova.model;

import com.hps.vilanova.model.enums.ModalidadeVisita;
import com.hps.vilanova.model.enums.StatusBaixa;
import com.hps.vilanova.model.enums.StatusSala;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "consultoria")
public class Consultoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "equipe_id", nullable = false)
    private Equipe equipe;

    private String unidadeSaude;
    private LocalDate dataConsultoria;
    private String solicitante;
    private LocalTime hora;


    @Enumerated(EnumType.STRING)
    private StatusBaixa statusBaixa;

    @Enumerated(EnumType.STRING)
    private ModalidadeVisita modalidadeVisita;

    private boolean statusConsultoria;

    @Enumerated(EnumType.STRING)
    private StatusSala statusSala;

    private String situacoesEspecificas;

    private String hospital;

}
