package com.hps.vilanova.service;

import com.hps.vilanova.exception.BadRequestException;
import com.hps.vilanova.model.Elegibilidade;
import com.hps.vilanova.repository.ElegibilidadeRepository;
import com.hps.vilanova.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class ElegibilidadeService {
    @Autowired
    private ElegibilidadeRepository elegibilidadeRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public Elegibilidade criarElegibilidade(Elegibilidade elegibilidadeRequest) {

        var pacienteOpt = pacienteRepository.findById(elegibilidadeRequest.getPaciente().getId());

        if (pacienteOpt.isEmpty()) {
            throw new BadRequestException("Paciente não encontrado");
        }
        var paciente = pacienteOpt.get();
        var elegibilidade = new Elegibilidade(elegibilidadeRequest);
        elegibilidade.setPaciente(paciente);
        elegibilidade.setNivel(elegibilidadeRequest.getNivel());
        elegibilidade.setDataDeCriacao(now());
        paciente.getElegibilidades().add(elegibilidade);
        return elegibilidadeRepository.save(elegibilidade);
    }


    public List<Elegibilidade> listarElegibilidades(){
        return elegibilidadeRepository.findAll();
    }

}
