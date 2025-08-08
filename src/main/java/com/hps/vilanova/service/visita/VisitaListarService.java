package com.hps.vilanova.service.visita;

import com.hps.vilanova.dto.response.visita.VisitaResponse;
import com.hps.vilanova.mapper.visita.VisitaMapper;
import com.hps.vilanova.model.enums.StatusVisita;
import com.hps.vilanova.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VisitaListarService {

    private final VisitaRepository visitaRepository;

    public List<VisitaResponse> listar(Long equipeId) {
        return visitaRepository.findByEquipeId(equipeId)
                .stream()
                .map(VisitaMapper::toVisitaResponse)
                .filter(v ->
                        v.getStatusVisita() != StatusVisita.ENCERRADA)
                .collect(Collectors.toList());
    }
}
