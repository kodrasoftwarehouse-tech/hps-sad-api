package com.hps.vilanova.controller.response.usuario;

import com.hps.vilanova.model.enums.Roles;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponse {

    private Long id;
    private String nome;
    private Roles roles;

}
