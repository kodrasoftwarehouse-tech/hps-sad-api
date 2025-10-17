package com.hps.vilanova.service.elegibilidade;

import com.hps.vilanova.dto.elegibilidade.ElegibilidadeResponse;
import com.hps.vilanova.exception.BadRequestException;
import com.hps.vilanova.mapper.ElegibilidadeMapper;
import com.hps.vilanova.model.Elegibilidade;
import com.hps.vilanova.repository.ElegibilidadeRepository;
import com.hps.vilanova.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class ElegibilidadeService {
    @Autowired
    private ElegibilidadeRepository elegibilidadeRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    @Transactional
    public ElegibilidadeResponse criarElegibilidade(Elegibilidade request) {

        var paciente = pacienteRepository.findById(request.getPaciente().getId())
                .orElseThrow(() -> new BadRequestException("Paciente não encontrado"));

        var elegibilidade = Elegibilidade.builder()
                .paciente(paciente)
                .nome(request.getNome())
                .nivel(request.getNivel())
                .dataDeCriacao(LocalDateTime.now())
                .build();

        paciente.getElegibilidades().add(elegibilidade);

        elegibilidadeRepository.save(elegibilidade);
        pacienteRepository.save(paciente);

        return ElegibilidadeMapper.toResponse(elegibilidade);
    }


    public List<Elegibilidade> listarElegibilidades(){
        return elegibilidadeRepository.findAll();
    }

}
