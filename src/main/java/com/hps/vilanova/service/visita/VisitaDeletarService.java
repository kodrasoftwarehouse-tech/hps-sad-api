package com.hps.vilanova.service.visita;

import com.hps.vilanova.model.Visita;
import com.hps.vilanova.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VisitaDeletarService {

    private final VisitaRepository visitaRepository;

    public void deletar(Long id) {
        Visita visita = visitaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Visita não encontrada!"));
        visitaRepository.delete(visita);
    }
}
