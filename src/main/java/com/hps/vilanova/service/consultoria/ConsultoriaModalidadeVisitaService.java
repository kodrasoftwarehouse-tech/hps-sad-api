package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaModalidadeVisitaRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaModalidadeVisitaService {

    private final ConsultoriaRepository consultoriaRepository;

    public void editar(Long id, @Valid ConsultoriaModalidadeVisitaRequest request) {
        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Consultoria não encontrada!"));

        consultoria.setModalidadeVisita(request.getModalidadeVisita());

        consultoriaRepository.save(consultoria);
    }
}
