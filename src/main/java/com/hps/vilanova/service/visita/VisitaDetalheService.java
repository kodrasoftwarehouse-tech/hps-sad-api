package com.hps.vilanova.service.visita;

import com.hps.vilanova.controller.response.visita.VisitaResponse;
import com.hps.vilanova.mapper.visita.VisitaMapper;
import com.hps.vilanova.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VisitaDetalheService {

    private final VisitaRepository visitaRepository;

    public VisitaResponse obter(Long corridaId) {
        return visitaRepository.findByCorridaId(corridaId)
                .map(VisitaMapper::toVisitaResponse)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Visita não encontrada"));
    }
}
