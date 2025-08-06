package com.hps.vilanova.service.visita;

import com.hps.vilanova.controller.request.visita.VisitaAgendarRequest;
import com.hps.vilanova.mapper.visita.VisitaMapper;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.Visita;
import com.hps.vilanova.repository.EquipeRepository;
import com.hps.vilanova.repository.PacienteRepository;
import com.hps.vilanova.repository.UsuarioRepository;
import com.hps.vilanova.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VisitaAgendarService {
    
    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final EquipeRepository equipeRepository;
    private final VisitaRepository visitaRepository;

    public void agendar(Long id, VisitaAgendarRequest request) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"paciente não encontrado"));
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"usuario não encontrado"));
        Equipe equipe = equipeRepository.findById(request.getEquipeId())
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"equipe não encontrada"));

        Visita visita = VisitaMapper.toAgendarVisita(paciente,usuario,equipe,request);

        visitaRepository.save(visita);
    }
}
