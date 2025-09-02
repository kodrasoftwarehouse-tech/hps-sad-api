package com.hps.vilanova.service.equipe;

import com.hps.vilanova.dto.request.equipe.EquipeRequest;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.repository.EquipeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class EquipeEditarService {

    private final EquipeRepository equipeRepository;

    @Transactional
    public void editar(@Valid EquipeRequest request, Long id) {

        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Equipe não encontrada"));

        equipe.setNome(request.getNome());

        equipeRepository.save(equipe);

    }
}
