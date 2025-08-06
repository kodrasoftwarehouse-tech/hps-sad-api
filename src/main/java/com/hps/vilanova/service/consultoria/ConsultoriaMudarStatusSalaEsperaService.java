package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaStatusSalaRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaMudarStatusSalaEsperaService {

    private final ConsultoriaRepository consultoriaRepository;


    public void mudarStatus(@Valid ConsultoriaStatusSalaRequest request, Long id) {
        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"consultoria não encontrada"));

        consultoria.setStatusSala(request.getStatusSala());
        consultoriaRepository.save(consultoria);

    }
}
