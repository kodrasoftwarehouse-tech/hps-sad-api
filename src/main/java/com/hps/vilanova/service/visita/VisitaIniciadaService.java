package com.hps.vilanova.service.visita;

import com.hps.vilanova.model.Visita;
import com.hps.vilanova.model.enums.StatusVisita;
import com.hps.vilanova.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VisitaIniciadaService {

    private final VisitaRepository visitaRepository;

    public void iniciar(Long id) {

        Visita visita = visitaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Visita não encontrada"));

        visita.setStatusVisita(StatusVisita.INICIADA);
        visita.setHoraInicial(LocalTime.now());

        visitaRepository.save(visita);
    }
}
