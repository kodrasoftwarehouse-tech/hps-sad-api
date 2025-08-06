package com.hps.vilanova.controller;

import com.hps.vilanova.controller.response.usuario.UsuarioResponse;
import com.hps.vilanova.service.usuario.UsuarioListarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioListarService usuarioListarService;

    @GetMapping("/listar")
    public List<UsuarioResponse> listar(){
        return usuarioListarService.listar();
    }

}

