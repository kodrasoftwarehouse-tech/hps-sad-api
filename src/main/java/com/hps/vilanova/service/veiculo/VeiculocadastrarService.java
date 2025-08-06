package com.hps.vilanova.service.veiculo;

import com.hps.vilanova.controller.request.veiculo.VeiculoRequest;
import com.hps.vilanova.mapper.veiculo.VeiculoMapper;
import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VeiculocadastrarService {

    private final VeiculoRepository veiculoRepository;

    @Transactional
    public void cadastrar(@Valid VeiculoRequest request) {

        Veiculo veiculo = VeiculoMapper.toEntity(request);
        veiculoRepository.save(veiculo);

    }
}
