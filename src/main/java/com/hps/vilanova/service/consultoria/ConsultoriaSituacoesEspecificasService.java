package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaSituacoesEspecificasRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaSituacoesEspecificasService {

    private final ConsultoriaRepository consultoriaRepository;

    @Transactional
    public void baixa(Long id, @Valid ConsultoriaSituacoesEspecificasRequest request) {

        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Consultoria não encontrada"));

        consultoria.setStatusConsultoria(false);
        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setSituacoesEspecificas(request.getSituacoesEspecificas());

        consultoriaRepository.save(consultoria);
    }
}
