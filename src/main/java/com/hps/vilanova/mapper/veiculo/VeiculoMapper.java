package com.hps.vilanova.mapper.veiculo;

import com.hps.vilanova.dto.request.veiculo.VeiculoRequest;
import com.hps.vilanova.dto.response.veiculo.VeiculoResponse;
import com.hps.vilanova.model.Veiculo;
import jakarta.validation.Valid;

import java.math.BigDecimal;

public class VeiculoMapper {


    public static Veiculo toEntity(@Valid VeiculoRequest request) {
        return Veiculo.builder()
                .placa(request.getPlaca())
                .modelo(request.getModelo())
                .kmRodado(BigDecimal.ZERO)
                .kmAtual(request.getKmAtual())
                .latitude(BigDecimal.ZERO)
                .longitude(BigDecimal.ZERO)
                .build();
    }

    public static VeiculoResponse toResponse(Veiculo veiculo) {
        return VeiculoResponse.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .modelo(veiculo.getModelo())
                .kmRodado(veiculo.getKmRodado())
                .kmAtual(veiculo.getKmAtual())
                .latitude(veiculo.getLatitude())
                .longitude(veiculo.getLongitude())
                .status(veiculo.isStatus())
                .build();
    }
}
