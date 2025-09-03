package com.hps.vilanova.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RelatorioUsuario {

    @EmbeddedId
    private RelatorioUsuarioId id;

    @ManyToOne
    @MapsId("relatorioId")
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public RelatorioUsuario(Relatorio relatorio, Usuario usuario) {
        this.relatorio = relatorio;
        this.usuario = usuario;
        this.id = new RelatorioUsuarioId(relatorio.getId(), usuario.getId());
    }
}
