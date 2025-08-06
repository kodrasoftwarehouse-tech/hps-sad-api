package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.mapper.consultoria.ConsultoriaMapper;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RequiredArgsConstructor
@Service
public class ConsultoriaDetalheService {

    private final ConsultoriaRepository consultoriaRepository;

    public ConsultoriaResponse buscar(Long id) {
        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() ->new  ResponseStatusException(NOT_FOUND,"Consultoria não encontrada"));


        return ConsultoriaMapper.toResponse(consultoria);

    }
}
