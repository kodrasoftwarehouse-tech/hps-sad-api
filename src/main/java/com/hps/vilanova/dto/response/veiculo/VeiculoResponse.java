package com.hps.vilanova.dto.response.veiculo;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VeiculoResponse {

    private Long id;
    private String placa;
    private String modelo;
    private BigDecimal kmRodado;
    private BigDecimal kmAtual;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private boolean status;
}
