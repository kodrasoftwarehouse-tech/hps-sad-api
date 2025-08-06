package com.hps.vilanova.model;


import com.hps.vilanova.model.enums.ClassificacaoVisita;
import com.hps.vilanova.model.enums.StatusVisita;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "corrida_id")
    private Corrida corrida;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    @OneToOne
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;

    private LocalTime horaInicial;

    private LocalTime horaFinal;

    @Enumerated(EnumType.STRING)
    private ClassificacaoVisita classificacao;

    @Enumerated(EnumType.STRING)
    private StatusVisita statusVisita;

}
