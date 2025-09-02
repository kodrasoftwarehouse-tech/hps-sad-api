package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.relatorio.RelatorioRequest;
import com.hps.vilanova.dto.request.visita.VisitaAgendarRequest;
import com.hps.vilanova.dto.response.visita.VisitaResponse;
import com.hps.vilanova.service.visita.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/visita")
public class VisitaController {

    private final VisitaListarService visitaListarService;
    private final VisitaDetalheService visitaDetalheService;
    private final VisitaAgendarService visitaAgendarService;
    private final VisitaIniciadaService visitaIniciadaService;
    private final VisitaRealizarService visitaRealizarService;
    private final VisitaEncerrarService visitaEncerrarService;
    private final VisitaDeletarService visitaDeletarService;

    @GetMapping("/{equipeId}")
    public List<VisitaResponse> listar(@PathVariable Long equipeId) {
        return visitaListarService.listar(equipeId);
    }

    @GetMapping("{corridaId}/detalhe")
    public VisitaResponse obter(@PathVariable Long corridaId) {
        return visitaDetalheService.obter(corridaId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/agendar")
    public void agendar(@PathVariable Long id, @Valid @RequestBody VisitaAgendarRequest request) {
        visitaAgendarService.agendar(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/iniciar")
    public void inciar(@PathVariable Long id) {
        visitaIniciadaService.iniciar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/realizada")
    public void realizar(@PathVariable Long id) {
        visitaRealizarService.realizar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/encerrar")
    public void encerrar(@PathVariable Long id, @Valid @RequestBody RelatorioRequest request) {
        visitaEncerrarService.encerrar(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        visitaDeletarService.deletar(id);
    }


}
