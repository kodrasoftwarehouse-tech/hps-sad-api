package com.hps.vilanova.controller;

import com.hps.vilanova.dto.elegibilidade.ElegibilidadeResponse;
import com.hps.vilanova.model.Elegibilidade;
import com.hps.vilanova.service.elegibilidade.ElegibilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/elegibilidade")
public class ElegibilidadeController {
    @Autowired
    private ElegibilidadeService elegibilidadeService;

    @PostMapping
    public ResponseEntity<ElegibilidadeResponse> criarElegibilidade(@RequestBody Elegibilidade elegibilidade){
        return ResponseEntity.status(CREATED).body(elegibilidadeService.criarElegibilidade(elegibilidade));
    }

    @GetMapping
    public List<Elegibilidade> elegibilidadeFindAll(){
        return elegibilidadeService.listarElegibilidades();
    }

}
