package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaEditarRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaEditarService {

    private final ConsultoriaRepository consultoriaRepository;

    public void editar(Long id, ConsultoriaEditarRequest request) {

        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"consultoria não encontrada"));

        consultoria.setUnidadeSaude(request.getUnidadeSaude());
        consultoria.setDataConsultoria(request.getDataConsultoria());
        consultoria.setSolicitante(request.getSolicitante());

        if (request.getStatusBaixa() != null){
            consultoria.setStatusBaixa(request.getStatusBaixa());
            consultoria.setStatusConsultoria(false);
        }
        if (request.getModalidadeVisita() != null){
            consultoria.setModalidadeVisita(request.getModalidadeVisita());
        }

        consultoriaRepository.save(consultoria);
    }
}
