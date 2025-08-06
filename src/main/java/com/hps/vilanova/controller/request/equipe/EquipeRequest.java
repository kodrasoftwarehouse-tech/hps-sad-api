package com.hps.vilanova.controller.request.equipe;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipeRequest {

    @NotBlank
    private String nome;

}
