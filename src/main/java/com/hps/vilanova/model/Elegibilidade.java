package com.hps.vilanova.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elegibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String nivel;
    private LocalDateTime dataDeCriacao;
}
