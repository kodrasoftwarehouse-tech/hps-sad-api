package com.hps.vilanova.service.paciente;

import com.hps.vilanova.dto.response.paciente.PacienteBuscaNomeResponse;
import com.hps.vilanova.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteBuscaService {

    private final PacienteRepository pacienteRepository;

    public Page<PacienteBuscaNomeResponse> buscar(String texto, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (texto == null || texto.isBlank()) {
            return pacienteRepository.findAllPacientes(pageable);
        } else {
            return pacienteRepository.search(texto.toLowerCase(), pageable);
        }
    }
}
