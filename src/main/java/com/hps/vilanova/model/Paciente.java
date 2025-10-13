package com.hps.vilanova.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private String cpf;
    private String cid;
    private String telefone1;
    private String telefone2;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Elegibilidade> elegibilidades;
    private boolean status;
}
