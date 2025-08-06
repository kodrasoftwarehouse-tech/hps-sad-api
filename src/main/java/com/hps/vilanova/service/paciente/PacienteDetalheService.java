package com.hps.vilanova.service.paciente;

import com.hps.vilanova.controller.response.paciente.PacienteDetalheResponse;
import com.hps.vilanova.mapper.paciente.PacienteDetalheMapper;
import com.hps.vilanova.model.Endereco;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.repository.EnderecoRepository;
import com.hps.vilanova.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteDetalheService {

    private final PacienteRepository pacienteRepository;
    private final EnderecoRepository enderecoRepository;

    public PacienteDetalheResponse detalhe(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id não encontrado"));

        Endereco endereco = enderecoRepository.findById(paciente.getEndereco().getId())
                .orElseThrow(() -> new RuntimeException("id não encontrado"));


        return PacienteDetalheMapper.toResponse(paciente, endereco);

    }
}
