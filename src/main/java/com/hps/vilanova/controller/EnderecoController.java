package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.endereco.EnderecoRequest;
import com.hps.vilanova.service.endereco.EnderecoEditarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoEditarService enderecoEditarService;

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @Valid @RequestBody EnderecoRequest request) {
        enderecoEditarService.editar(id, request);
    }

}
