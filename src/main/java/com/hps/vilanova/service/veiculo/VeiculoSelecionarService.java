package com.hps.vilanova.service.veiculo;

import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VeiculoSelecionarService {

    private final VeiculoRepository veiculoRepository;

    @Transactional
    public void selecionar(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Veiculo não encontrado"));
        veiculo.setStatus(true);
        veiculoRepository.save(veiculo);
    }

    @Transactional
    public void limpar(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Veiculo não encontrado"));
        veiculo.setStatus(false);
        veiculoRepository.save(veiculo);
    }
}
