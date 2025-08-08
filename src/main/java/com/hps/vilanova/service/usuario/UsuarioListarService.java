package com.hps.vilanova.service.usuario;

import com.hps.vilanova.dto.response.usuario.UsuarioResponse;
import com.hps.vilanova.mapper.usuario.UsuarioMapper;
import com.hps.vilanova.model.enums.Roles;
import com.hps.vilanova.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioListarService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> listar() {
        return usuarioRepository.findByRolesNot(Roles.ADMIN)
                .stream()
                .map(UsuarioMapper::toResponse)
                .toList();
    }
}
