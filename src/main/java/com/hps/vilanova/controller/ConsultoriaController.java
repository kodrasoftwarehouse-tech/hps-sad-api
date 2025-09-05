package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.dto.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.service.consultoria.ConsultoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consultoria")
public class ConsultoriaController {

    private final ConsultoriaService consultoriaService;

    @GetMapping("/fechadas")
    @ResponseStatus(HttpStatus.OK)
    public Page<ConsultoriaResponse> listarConsultoriasBaixadas(Pageable pageable) {
        return consultoriaService.listarConsultoriasBaixadas(pageable);
    }

    @GetMapping("/sala-de-espera/{equipeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsultoriaResponse> listarConsultoriasPendentesPrimeiraVisitaPorEquipe(@PathVariable Long equipeId) {
        return consultoriaService.listarConsultoriasPendentesPrimeiraVisitaPorEquipe(equipeId);
    }

    @GetMapping("/aguardando-primeira-vd/{equipeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsultoriaResponse> listarConsultoriasAtivasPorEquipe(@PathVariable Long equipeId) {
        return consultoriaService.listarConsultoriasAtivasPorEquipe(equipeId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsultoriaResponse buscarConsultoriaPorId(@PathVariable Long id) {
        return consultoriaService.buscarConsultoriaPorId(id);
    }

    @PutMapping("/status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatusSala(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.atualizarStatusSala(request, id);
    }

    @PutMapping("/equipe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEquipe(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.atualizarEquipe(id, request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDadosConsultoria(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.atualizarDadosConsultoria(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarConsultoria(@Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.criarConsultoria(request);
    }

    @PutMapping("/{id}/baixa")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registrarBaixa(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.registrarBaixa(id, request);
    }

    @PutMapping("/{id}/situacoes-especificas")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registrarBaixaComSituacoesEspecificas(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.registrarBaixaComSituacoesEspecificas(id, request);
    }

    @PutMapping("/{id}/hospital-baixa")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registrarBaixaHospitalar(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.registrarBaixaHospitalar(id, request);
    }

    @PutMapping("/{id}/modalidade-visita")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarModalidadeVisita(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.atualizarModalidadeVisita(id, request);
    }
}