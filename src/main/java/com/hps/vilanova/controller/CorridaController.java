package com.hps.vilanova.controller;

import com.hps.vilanova.controller.request.corrida.CorridaCadastroRequest;
import com.hps.vilanova.controller.request.corrida.CorridaCancelarRequest;
import com.hps.vilanova.controller.request.corrida.CorridaFinalizarRequest;
import com.hps.vilanova.controller.response.corrida.CorridaCadastroResponse;
import com.hps.vilanova.controller.response.corrida.CorridaResponse;
import com.hps.vilanova.service.corrida.CorridaCadastrarService;
import com.hps.vilanova.service.corrida.CorridaCancelarService;
import com.hps.vilanova.service.corrida.CorridaDetalheService;
import com.hps.vilanova.service.corrida.CorridaFinalizarservice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/corrida")
public class CorridaController {

    private final CorridaDetalheService corridaDetalheService;
    private final CorridaFinalizarservice corridaFinalizarservice;
    private final CorridaCadastrarService corridaCadastrarService;
    private final CorridaCancelarService corridaCancelarService;

    @GetMapping("/{id}")
    public CorridaResponse detalhe(@PathVariable Long id){
        return corridaDetalheService.detalhe(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public CorridaCadastroResponse cadastrar(@PathVariable Long id,@Valid @RequestBody CorridaCadastroRequest request){
      return corridaCadastrarService.cadastrar(id,request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/finalizar")
    public void finalizarCorrida(@PathVariable Long id, @Valid @RequestBody CorridaFinalizarRequest request){
        corridaFinalizarservice.finalizar(id,request);
    }

    @PutMapping("{id}/cancelar")
    public void cancelar(@PathVariable Long id, @RequestBody CorridaCancelarRequest request){
        corridaCancelarService.cancelar(id,request);
    }

}
