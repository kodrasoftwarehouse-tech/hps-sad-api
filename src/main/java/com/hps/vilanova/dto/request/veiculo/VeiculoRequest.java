package com.hps.vilanova.dto.request.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VeiculoRequest {
    @NotBlank
    private String placa;
    @NotBlank
    private String modelo;
    @NotNull
    private BigDecimal kmAtual;
}
