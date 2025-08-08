package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.paciente.PacienteAdicionarRequest;
import com.hps.vilanova.dto.request.paciente.PacienteEditarRequest;
import com.hps.vilanova.dto.response.paciente.PacienteAdicionarReponse;
import com.hps.vilanova.dto.response.paciente.PacienteBuscaNomeResponse;
import com.hps.vilanova.dto.response.paciente.PacienteDetalheResponse;
import com.hps.vilanova.service.paciente.PacienteAdicionarService;
import com.hps.vilanova.service.paciente.PacienteBuscaService;
import com.hps.vilanova.service.paciente.PacienteDetalheService;
import com.hps.vilanova.service.paciente.PacienteEditarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteBuscaService pacienteBuscaService;
    private final PacienteDetalheService pacienteDetalheService;
    private final PacienteAdicionarService pacienteAdicionarService;
    private final PacienteEditarService pacienteEditarService;


    @GetMapping("/buscar")
    public Page<PacienteBuscaNomeResponse> buscaPorNome(
            @RequestParam(required = false) String texto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return pacienteBuscaService.buscar(texto, page, size);
    }


    @GetMapping("/{id}")
    public PacienteDetalheResponse detalhe(@PathVariable Long id) {
        return pacienteDetalheService.detalhe(id);
    }

    @PostMapping
    public PacienteAdicionarReponse adicionar(@Valid @RequestBody PacienteAdicionarRequest request) {
        return pacienteAdicionarService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void editar(@RequestBody PacienteEditarRequest request, @PathVariable Long id) {
        pacienteEditarService.editar(request, id);
    }

}
