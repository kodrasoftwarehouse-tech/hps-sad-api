package com.hps.vilanova.service.equipe;

import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class EquipeDeletarService {

    private final EquipeRepository equipeRepository;

    public void deletar(Long id) {

        Equipe equipe = equipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Equipe não encontrada"));

        equipeRepository.delete(equipe);

    }
}
