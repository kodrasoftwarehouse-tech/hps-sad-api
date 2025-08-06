package com.hps.vilanova.service.consultoria;


import com.hps.vilanova.controller.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.mapper.consultoria.ConsultoriaMapper;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.model.enums.StatusSala;
import com.hps.vilanova.repository.ConsultoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultoriaListaVisitaService {

    private final ConsultoriaRepository consultoriaRepository;

    public List<ConsultoriaResponse> lista(Long equipeId) {

        return consultoriaRepository.findByEquipeId(equipeId)
                .stream()
                .map(ConsultoriaMapper::toResponse)
                .filter(c ->
                        c.isStatusConsultoria() &&
                        c.getStatusSala() == StatusSala.AGUARDANDO_PRIMEIRA_VD &&
                        c.getModalidadeVisita() != null)
                .collect(Collectors.toList());
    }
}
