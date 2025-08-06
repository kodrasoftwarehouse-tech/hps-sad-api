package com.hps.vilanova.service.veiculo;

import com.hps.vilanova.controller.response.veiculo.VeiculoResponse;
import com.hps.vilanova.mapper.veiculo.VeiculoMapper;
import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VeiculoDetalheService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoResponse detalhe(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Veiculo não encontrado"));
        return VeiculoMapper.toResponse(veiculo);
    }
}
