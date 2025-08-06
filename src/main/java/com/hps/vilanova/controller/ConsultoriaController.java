package com.hps.vilanova.controller;

import com.hps.vilanova.controller.request.consultoria.*;
import com.hps.vilanova.controller.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.service.consultoria.*;
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

    private final ConsultoriaFechadaPaginadaService consultoriaFechadaPaginadaService;
    private final ConsultoriaSalaEsperaService consultoriaSalaEsperaService;
    private final ConsultoriaListaVisitaService consultoriaListaVisitaService;
    private final ConsultoriaDetalheService consultoriaDetalheService;
    private final ConsultoriaEditarEquipeService consultoriaEditarEquipeService;
    private final ConsultoriaMudarStatusSalaEsperaService consultoriaMudarStatusSalaEsperaService;
    private final ConsultoriaEditarService consultoriaEditarService;
    private final ConsultoriaAdicionarService consultoriaAdicionarService;
    private final ConsultoriaBaixaSalaEsperaService consultoriaBaixaSalaEsperaService;
    private final ConsultoriaSituacoesEspecificasService consultoriaSituacoesEspecificasService;
    private final ConsultoriaHospitalBaixaService consultoriaHospitalBaixaService;
    private final ConsultoriaModalidadeVisitaService consultoriaModalidadeVisitaService;

    @GetMapping("/fechadas")
    public Page<ConsultoriaResponse> consultoriaFechada(Pageable pageable){
       return consultoriaFechadaPaginadaService.buscar(pageable);
    }

    @GetMapping("/sala-de-espera/{equipeId}")
    public List<ConsultoriaResponse> listaSala(@PathVariable Long equipeId){
        return consultoriaSalaEsperaService.listar(equipeId);
    }

    @GetMapping("/aguardando-primeira-vd/{equipeId}")
    public List<ConsultoriaResponse> listarConsultoria(@PathVariable Long equipeId){
        return consultoriaListaVisitaService.lista(equipeId);
    }

    @GetMapping("/{id}")
    public ConsultoriaResponse buscar(@PathVariable Long id){
        return consultoriaDetalheService.buscar(id);
    }

    @PutMapping("/status/{id}")
    public void mudarStatus(@Valid @RequestBody ConsultoriaStatusSalaRequest request, @PathVariable Long id){
        consultoriaMudarStatusSalaEsperaService.mudarStatus(request, id);
    }

    @PutMapping("/equipe/{id}")
    public void mudarEquipe(@Valid @PathVariable Long id, @RequestBody ConsultoriaEditaEquipeRequest request){
        consultoriaEditarEquipeService.editar(id,request);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @Valid @RequestBody ConsultoriaEditarRequest request){
        consultoriaEditarService.editar(id, request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void adicionar(@Valid @RequestBody ConsultoriaRequest request){
        consultoriaAdicionarService.adicionar(request);
    }

    @PutMapping("/{id}/baixa")
    public void baixaSalaEspera(@PathVariable Long id, @Valid @RequestBody ConsultoriaBaixaRequest request){
        consultoriaBaixaSalaEsperaService.baixa(id,request);
    }

    @PutMapping("/{id}/situacoes-especificas")
    public void baixaSalaEspera(@PathVariable Long id, @Valid @RequestBody ConsultoriaSituacoesEspecificasRequest request){
        consultoriaSituacoesEspecificasService.baixa(id,request);
    }

    @PutMapping("/{id}/hospital-baixa")
    public void baixaSalaEspera(@PathVariable Long id, @Valid @RequestBody ConsultoriaHospitalBaixaRequest request){
        consultoriaHospitalBaixaService.baixa(id,request);
    }

    @PutMapping("/{id}/modalidade-visita")
    public void modalidadeVisita(@PathVariable Long id, @Valid @RequestBody ConsultoriaModalidadeVisitaRequest request){
        consultoriaModalidadeVisitaService.editar(id,request);
    }
}
