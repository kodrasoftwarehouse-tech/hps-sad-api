package com.hps.vilanova.controller;

import com.hps.vilanova.controller.request.equipe.EquipeRequest;
import com.hps.vilanova.controller.response.equipe.EquipeResponse;
import com.hps.vilanova.service.equipe.EquipeCadastrarService;
import com.hps.vilanova.service.equipe.EquipeDeletarService;
import com.hps.vilanova.service.equipe.EquipeEditarService;
import com.hps.vilanova.service.equipe.EquipeListarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/equipe")
public class EquipeController {

    private final EquipeListarService equipeListarService;
    private final EquipeEditarService equipeEditarService;
    private final EquipeCadastrarService equipeCadastrarService;
    private final EquipeDeletarService equipeDeletarService;


    @GetMapping("/listar")
    public List<EquipeResponse> listar(){
        return equipeListarService.listar();
    }

    @PutMapping("/{id}")
    public void editar(@Valid @RequestBody EquipeRequest request, @PathVariable Long id ){
        equipeEditarService.editar(request, id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public  void cadastrar(@Valid @RequestBody EquipeRequest request){
        equipeCadastrarService.cadastrar(request);
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        equipeDeletarService.deletar(id);
    }
}
