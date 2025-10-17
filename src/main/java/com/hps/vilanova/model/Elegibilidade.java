package com.hps.vilanova.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elegibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private String nivel;
//    @OneToOne
//    private Equipe equipe;
    private LocalDateTime dataDeCriacao;

    public Elegibilidade(Elegibilidade elegibilidadeRequest) {
    }
}
