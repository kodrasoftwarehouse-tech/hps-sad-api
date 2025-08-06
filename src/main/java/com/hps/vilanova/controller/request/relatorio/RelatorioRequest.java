package com.hps.vilanova.controller.request.relatorio;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RelatorioRequest {

    @NotNull
    private boolean agudizou;
    @NotNull
    private boolean intercorreu;
    @NotNull
    private boolean internacaoEvitada;
    @NotNull
    private LocalDate dataRelatorio;
    @NotEmpty
    private List<RelatorioUsuarioRequest> usuarios;

    private String observacoes;


}
