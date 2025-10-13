package com.hps.vilanova.service;

import com.hps.vilanova.model.Elegibilidade;
import com.hps.vilanova.repository.ElegibilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class ElegibilidadeService {

    private ElegibilidadeRepository elegibilidadeRepository;

    public Elegibilidade criarElegibilidade(Elegibilidade elegibilidadeRequest){
        var elegibilidade = new Elegibilidade();
        elegibilidade.setPaciente(elegibilidadeRequest.getPaciente());
        elegibilidade.setEquipe(elegibilidade.getEquipe());
        elegibilidade.setNivel(elegibilidadeRequest.getNivel());
        elegibilidade.setDataDeCriacao(now());
        elegibilidade.setNome(elegibilidadeRequest.getNome());
        return elegibilidadeRepository.save(elegibilidade);
    }


    public List<Elegibilidade> listarElegibilidades(){
        return elegibilidadeRepository.findAll();
    }

}
