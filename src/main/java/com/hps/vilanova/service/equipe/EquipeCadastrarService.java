package com.hps.vilanova.service.equipe;

import com.hps.vilanova.controller.request.equipe.EquipeRequest;
import com.hps.vilanova.mapper.equipe.EquipeMapper;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.repository.EquipeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EquipeCadastrarService {


    private final EquipeRepository equipeRepository;

    @Transactional
    public void cadastrar(EquipeRequest request) {

        Equipe equipe = EquipeMapper.toEntity(request);

        equipeRepository.save(equipe);

    }
}
