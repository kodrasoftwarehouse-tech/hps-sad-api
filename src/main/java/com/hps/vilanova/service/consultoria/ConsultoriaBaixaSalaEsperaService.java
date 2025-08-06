package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaBaixaRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaBaixaSalaEsperaService {

    private final ConsultoriaRepository consultoriaRepository;


    public void baixa(Long id, @Valid ConsultoriaBaixaRequest request) {

        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Consultoria não encontrada"));

        consultoria.setStatusSala(request.getStatusSala());
        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setStatusConsultoria(false);

        consultoriaRepository.save(consultoria);
    }
}
