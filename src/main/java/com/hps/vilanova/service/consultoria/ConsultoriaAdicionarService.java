package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.controller.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.mapper.consultoria.ConsultoriaMapper;
import com.hps.vilanova.model.Consultoria;
import com.hps.vilanova.model.Equipe;
import com.hps.vilanova.model.Paciente;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.repository.ConsultoriaRepository;
import com.hps.vilanova.repository.EquipeRepository;
import com.hps.vilanova.repository.PacienteRepository;
import com.hps.vilanova.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultoriaAdicionarService {

    private final PacienteRepository pacienteRepository;
    private final EquipeRepository equipeRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConsultoriaRepository consultoriaRepository;

    public void adicionar(@Valid ConsultoriaRequest request) {

        Paciente paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Equipe equipe = equipeRepository.findById(request.getEquipeId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Consultoria consultoria = ConsultoriaMapper.toEntity(request, usuario, paciente,equipe);

        consultoriaRepository.save(consultoria);
    }
}
