package com.hps.vilanova.service.veiculo;

import com.hps.vilanova.dto.response.veiculo.VeiculoResponse;
import com.hps.vilanova.mapper.veiculo.VeiculoMapper;
import com.hps.vilanova.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VeiculoListarService {

    private final VeiculoRepository veiculoRepository;

    public List<VeiculoResponse> listar() {
        return veiculoRepository.findAll().stream()
                .map(VeiculoMapper::toResponse)
                .toList();
    }
}
