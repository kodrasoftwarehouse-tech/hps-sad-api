package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.mapper.consultoria.ConsultoriaMapper;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultoriaSalaEsperaService {

    private final ConsultoriaRepository consultoriaRepository;

    public List<ConsultoriaResponse> listar(Long equipeId) {
        List<Consultoria> consultorias = consultoriaRepository.findByEquipeId(equipeId);

        return consultorias.stream()
                .map(ConsultoriaMapper::toResponse)
                .filter(ConsultoriaResponse::isStatusConsultoria)
                .collect(Collectors.toList());
    }
}
