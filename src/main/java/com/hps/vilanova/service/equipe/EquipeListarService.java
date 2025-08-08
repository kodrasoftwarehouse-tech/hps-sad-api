package com.hps.vilanova.service.equipe;

import com.hps.vilanova.dto.response.equipe.EquipeResponse;
import com.hps.vilanova.mapper.equipe.EquipeMapper;
import com.hps.vilanova.repository.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class EquipeListarService {

    private final EquipeRepository equipeRepository;

    public List<EquipeResponse> listar() {

        return equipeRepository.findAll()
                .stream()
                .map(EquipeMapper::toResponse)
                .toList();
    }
}
