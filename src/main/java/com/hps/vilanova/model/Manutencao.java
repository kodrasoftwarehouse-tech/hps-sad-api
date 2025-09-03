package com.hps.vilanova.model;


import com.hps.vilanova.model.enums.SolicitacaoManutencao;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "corrida_id")
    private Corrida CorridaId;

    @Enumerated(EnumType.STRING)
    private SolicitacaoManutencao solicitacaoManutencao;

    private String explicacao;


}
