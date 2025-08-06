package com.hps.vilanova.mapper.posicao;

import com.hps.vilanova.model.Posicao;
import jakarta.validation.constraints.NotNull;

public class PosicaoMapper {

    public static Posicao toEntity(@NotNull Posicao posicao) {
        return Posicao.builder()
                .latitude(posicao.getLatitude())
                .longitude(posicao.getLongitude())
                .build();
    }
}
