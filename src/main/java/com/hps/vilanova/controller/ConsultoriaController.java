package com.hps.vilanova.controller;

import com.hps.vilanova.dto.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.dto.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.service.consultoria.ConsultoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
    public ResponseEntity<ConsultoriaResponse> atualizarStatusSala(@Valid @RequestBody ConsultoriaRequest request, @PathVariable Long id) {
        return ResponseEntity.status(OK).body(consultoriaService.atualizarStatusSala(request, id));
    }

    @PutMapping("/equipe/{id}")
    public ResponseEntity<ConsultoriaResponse> atualizarEquipe(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        return ResponseEntity.status(OK).body(consultoriaService.atualizarEquipe(id, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultoriaResponse> atualizarDadosConsultoria(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        return ResponseEntity.status(OK).body(consultoriaService.atualizarDadosConsultoria(id, request));
    }

    @PostMapping()
    public ResponseEntity<ConsultoriaResponse> criarConsultoria(@Valid @RequestBody  ConsultoriaRequest request) {
        return ResponseEntity.status(CREATED).body(consultoriaService.criarConsultoria(request));
    }

    @PutMapping("/{id}/baixa")
    public ResponseEntity<ConsultoriaResponse> registrarBaixa(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        return ResponseEntity.status(OK).body(consultoriaService.registrarBaixa(id, request));
    }

    @PutMapping("/{id}/situacoes-especificas")
    public ResponseEntity<ConsultoriaResponse> registrarBaixaComSituacoesEspecificas(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        return ResponseEntity.status(OK).body(consultoriaService.registrarBaixaComSituacoesEspecificas(id, request));
    }

    @PutMapping("/{id}/hospital-baixa")
    public ResponseEntity<ConsultoriaResponse> registrarBaixaHospitalar(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        return ResponseEntity.status(OK).body(consultoriaService.registrarBaixaHospitalar(id, request));
    }

    @PutMapping("/{id}/modalidade-visita")
    public ResponseEntity<ConsultoriaResponse> atualizarModalidadeVisita(@PathVariable Long id, @Valid @RequestBody ConsultoriaRequest request) {
        return ResponseEntity.status(OK).body(consultoriaService.atualizarModalidadeVisita(id, request));
    }
}
