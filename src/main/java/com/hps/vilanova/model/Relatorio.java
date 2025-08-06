package com.hps.vilanova.model;

import com.hps.vilanova.model.enums.ViaAdmin;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean agudizou;

    private boolean intercorreu;

    private boolean internacaoEvitada;

    private LocalDate dataRelatorio;

    @Enumerated(EnumType.STRING)
    private ViaAdmin viaAdmin;

    private String observacoes;

    @OneToMany(mappedBy = "relatorio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<RelatorioUsuario> usuarios = new HashSet<>();

}
