package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaEditaEquipeRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.model.enums.StatusSala;
import com.hps.vilanova.repository.ConsultoriaRepository;
import com.hps.vilanova.repository.EquipeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaEditarEquipeService {

    private final ConsultoriaRepository consultoriaRepository;
    private final EquipeRepository equipeRepository;

    @Transactional
    public void editar(@Valid Long id, ConsultoriaEditaEquipeRequest request) {
        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"consultoria não encontrada"));
        Equipe equipe = equipeRepository.findById(request.getEquipeId())
                        .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"eQUIPE NÃO ENCONTRADA"));
        consultoria.setEquipe(equipe);
        consultoria.setStatusSala(StatusSala.AGUARDANDO_DISCUSSAO_EMADS);
        consultoriaRepository.save(consultoria);
    }
}
