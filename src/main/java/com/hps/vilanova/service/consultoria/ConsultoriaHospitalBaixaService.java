package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaHospitalBaixaRequest;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.repository.ConsultoriaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaHospitalBaixaService {

    private final ConsultoriaRepository consultoriaRepository;

    public void baixa(Long id, @Valid ConsultoriaHospitalBaixaRequest request) {
        Consultoria consultoria = consultoriaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Consultoria não encontrada!"));
        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setStatusSala(request.getStatusSala());
        consultoria.setStatusConsultoria(false);
        consultoria.setHospital(request.getHospital());

        consultoriaRepository.save(consultoria);
    }
}
