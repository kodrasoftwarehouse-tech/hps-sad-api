package com.hps.vilanova.service.corrida;

import com.hps.vilanova.dto.response.corrida.CorridaResponse;
import com.hps.vilanova.mapper.corrida.CorridaMapper;
import com.hps.vilanova.model.Corrida;
import com.hps.vilanova.repository.CorridaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class CorridaDetalheService {

    private final CorridaRepository corridaRepository;

    public CorridaResponse detalhe(Long id) {

        Corrida corrida = corridaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Corrida não encontrada"));

        return CorridaMapper.toDetalheResponse(corrida);

    }
}
