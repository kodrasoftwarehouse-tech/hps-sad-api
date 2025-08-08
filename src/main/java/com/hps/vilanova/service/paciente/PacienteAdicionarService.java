package com.hps.vilanova.service.paciente;

import com.hps.vilanova.dto.request.paciente.PacienteAdicionarRequest;
import com.hps.vilanova.dto.response.paciente.PacienteAdicionarReponse;
import com.hps.vilanova.mapper.endereco.EnderecoMapper;
import com.hps.vilanova.mapper.paciente.AdicionarPacienteMapper;
import com.hps.vilanova.model.Endereco;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.repository.EnderecoRepository;
import com.hps.vilanova.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteAdicionarService {

    private final PacienteRepository pacienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Transactional
    public PacienteAdicionarReponse adicionar(PacienteAdicionarRequest request) {

        Endereco endereco = EnderecoMapper.toEntity(request.getEndereco());
        endereco = enderecoRepository.saveAndFlush(endereco);

        Paciente paciente = AdicionarPacienteMapper.toEntity(request, endereco);
        paciente = pacienteRepository.saveAndFlush(paciente);

        return AdicionarPacienteMapper.toResponse(paciente);
    }
}
