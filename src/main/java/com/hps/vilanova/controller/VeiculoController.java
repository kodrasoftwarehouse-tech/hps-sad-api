package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.veiculo.VeiculoEditarRequest;
import com.hps.vilanova.dto.request.veiculo.VeiculoRequest;
import com.hps.vilanova.dto.response.corrida.CorridaResponse;
import com.hps.vilanova.dto.response.veiculo.VeiculoResponse;
import com.hps.vilanova.service.veiculo.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoDetalheService veiculoDetalheService;
    private final VeiculoBuscarHistorioService veiculoBuscarHistorioService;
    private final VeiculoListarService veiculoListarService;
    private final VeiculoEditarService veiculoEditarService;
    private final VeiculocadastrarService veiculocadastrarService;
    private final VeiculoSelecionarService veiculoSelecionarService;
    private final VeiculoDeletarService veiculoDeletarService;

    @GetMapping("/{id}")
    public VeiculoResponse detalheVeiculo(@PathVariable Long id) {
        return veiculoDetalheService.detalhe(id);
    }

    @GetMapping("/{id}/historico")
    public Page<CorridaResponse> buscarHistorico(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal,
            Pageable pageable
    ) {
        return veiculoBuscarHistorioService.buscarHistorico(id, dataInicial, dataFinal, pageable);
    }

    @GetMapping("/lista")
    public List<VeiculoResponse> lista() {
        return veiculoListarService.listar();
    }


    @ResponseStatus(OK)
    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @Valid @RequestBody VeiculoEditarRequest request) {
        veiculoEditarService.editar(id, request);
    }

    @PutMapping("/{id}/selecionar")
    public void selecionar(@PathVariable Long id) {
        veiculoSelecionarService.selecionar(id);
    }

    @PutMapping("/{id}/limpar")
    public void limpar(@PathVariable Long id) {
        veiculoSelecionarService.limpar(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void cadastrar(@Valid @RequestBody VeiculoRequest request) {
        veiculocadastrarService.cadastrar(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoDeletarService.deletar(id);
    }

}
