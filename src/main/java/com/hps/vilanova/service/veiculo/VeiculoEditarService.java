package com.hps.vilanova.service.veiculo;

import com.hps.vilanova.dto.request.veiculo.VeiculoEditarRequest;
import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VeiculoEditarService {

    private final VeiculoRepository veiculoRepository;

    @Transactional
    public void editar(Long id, @Valid VeiculoEditarRequest request) {

        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Veiculo não encontrado"));

        veiculo.setPlaca(request.getPlaca());
        veiculo.setModelo(request.getModelo());
        veiculo.setKmRodado(request.getKmRodado());
        veiculo.setKmAtual(request.getKmAtual());
        veiculo.setLatitude(request.getLatitude());
        veiculo.setLongitude(request.getLongitude());

        veiculoRepository.save(veiculo);

    }
}
