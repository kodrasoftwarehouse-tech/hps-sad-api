package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.mapper.consultoria.ConsultoriaMapper;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultoriaFechadaPaginadaService {

    private final ConsultoriaRepository consultoriaRepository;

    public Page<ConsultoriaResponse> buscar(Pageable pageable) {
        Page<Consultoria> consultorias = consultoriaRepository.findByStatusConsultoriaFalse(pageable);
        return consultorias.map(ConsultoriaMapper::toResponse);
    }
}
