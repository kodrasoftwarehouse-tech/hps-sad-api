package com.hps.vilanova.service.paciente;

import com.hps.vilanova.dto.request.endereco.EnderecoRequest;
import com.hps.vilanova.dto.request.paciente.PacienteEditarRequest;
import com.hps.vilanova.model.Endereco;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.repository.EnderecoRepository;
import com.hps.vilanova.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PacienteEditarService {

    private final PacienteRepository pacienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Transactional
    public void editar(PacienteEditarRequest request, Long pacienteId) {

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("paciente não encontrado"));

        Endereco endereco = enderecoRepository.findById(paciente.getEndereco().getId())
                .orElseThrow(() -> new RuntimeException("endereço nao encontrado"));

        EnderecoRequest novoEndereco = request.getEndereco();


        endereco.setLogradouro(novoEndereco.getLogradouro());
        endereco.setComplemento(novoEndereco.getComplemento());
        endereco.setNumero(novoEndereco.getNumero());
        endereco.setBairro(novoEndereco.getBairro());
        endereco.setCidade(novoEndereco.getCidade());
        endereco.setCep(novoEndereco.getCep());
        endereco.setEstado(novoEndereco.getEstado());


        paciente.setNome(request.getNome());
        paciente.setIdade(request.getIdade());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setTelefone1(request.getTelefone1());
        paciente.setTelefone2(request.getTelefone2());
        paciente.setCpf(request.getCpf());
        paciente.setCid(request.getCid());
        paciente.setStatus(request.getStatus());


        pacienteRepository.save(paciente);

    }
}
