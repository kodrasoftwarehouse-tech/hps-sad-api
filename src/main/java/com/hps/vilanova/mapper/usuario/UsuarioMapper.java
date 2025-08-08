package com.hps.vilanova.mapper.usuario;

import com.hps.vilanova.dto.response.usuario.UsuarioResponse;
import com.hps.vilanova.model.Usuario;

public class UsuarioMapper {


    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .roles(usuario.getRoles())
                .build();
    }
}
