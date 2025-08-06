package com.hps.vilanova.controller.request.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VeiculoEditarRequest {

    @NotBlank
    private String placa;
    @NotBlank
    private String modelo;
    @NotNull
    private BigDecimal kmRodado;
    @NotNull
    private BigDecimal kmAtual;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;

}
