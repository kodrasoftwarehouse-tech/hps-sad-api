package com.hps.vilanova.mapper.equipe;

import com.hps.vilanova.dto.request.equipe.EquipeRequest;
import com.hps.vilanova.dto.response.equipe.EquipeResponse;
import com.hps.vilanova.model.Equipe;

public class EquipeMapper {


    public static Equipe toEntity(EquipeRequest request) {
        return Equipe.builder()
                .nome(request.getNome())
                .build();
    }

    public static EquipeResponse toResponse(Equipe equipe) {
        return EquipeResponse.builder()
                .id(equipe.getId())
                .nome(equipe.getNome())
                .build();

    }
}
