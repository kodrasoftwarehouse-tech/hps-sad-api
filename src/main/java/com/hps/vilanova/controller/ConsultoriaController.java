package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.dto.request.consultoria.ConsultoriaUpdateRequest;
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
    public Page<ConsultoriaResponse> listarConsultoriasBaixadas(Pageable pageable) {
        return consultoriaService.listarConsultoriasBaixadas(pageable);
    }

    @GetMapping("/sala-de-espera/{equipeId}")
    public List<ConsultoriaResponse> listarConsultoriasPendentesPrimeiraVisitaPorEquipe(@PathVariable Long equipeId) {
        return consultoriaService.listarConsultoriasPendentesPrimeiraVisitaPorEquipe(equipeId);
    }

    @GetMapping("/aguardando-primeira-vd/{equipeId}")
    public List<ConsultoriaResponse> listarConsultoriasAtivasPorEquipe(@PathVariable Long equipeId) {
        return consultoriaService.listarConsultoriasAtivasPorEquipe(equipeId);
    }

    @GetMapping("/{id}")
    public ConsultoriaResponse buscarConsultoriaPorId(@PathVariable Long id) {
        return consultoriaService.buscarConsultoriaPorId(id);
    }

    @PutMapping("/status/{id}")
    public void atualizarStatusSala(@Valid @RequestBody ConsultoriaRequest request, @PathVariable Long id) {
        consultoriaService.atualizarStatusSala(request, id);
    }

    @PutMapping("/equipe/{id}")
    public void atualizarEquipe(@Valid @PathVariable Long id, @RequestBody ConsultoriaRequest request) {
        consultoriaService.atualizarEquipe(id, request);
    }

    @PutMapping("/{id}")
    public void atualizarDadosConsultoria(@PathVariable Long id, @Valid @RequestBody ConsultoriaUpdateRequest request) {
        consultoriaService.atualizarDadosConsultoria(id, request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void criarConsultoria(@Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.criarConsultoria(request);
    }

    @PutMapping("/{id}/baixa")
    public void registrarBaixa(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.registrarBaixa(id, request);
    }

    @PutMapping("/{id}/situacoes-especificas")
    public void registrarBaixaComSituacoesEspecificas(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.registrarBaixaComSituacoesEspecificas(id, request);
    }

    @PutMapping("/{id}/hospital-baixa")
    public void registrarBaixaHospitalar(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.registrarBaixaHospitalar(id, request);
    }

    @PutMapping("/{id}/modalidade-visita")
    public void atualizarModalidadeVisita(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        consultoriaService.atualizarModalidadeVisita(id, request);
    }
}
