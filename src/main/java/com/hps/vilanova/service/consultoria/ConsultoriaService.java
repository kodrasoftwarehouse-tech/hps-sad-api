package com.hps.vilanova.service.consultoria;

import com.hps.vilanova.dto.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.dto.response.consultoria.ConsultoriaResponse;
import com.hps.vilanova.mapper.consultoria.ConsultoriaMapper;
import com.hps.vilanova.repository.ConsultoriaRepository;
import com.hps.vilanova.repository.EquipeRepository;
import com.hps.vilanova.repository.PacienteRepository;
import com.hps.vilanova.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.hps.vilanova.model.enums.StatusSala.AGUARDANDO_DISCUSSAO_EMADS;
import static com.hps.vilanova.model.enums.StatusSala.AGUARDANDO_PRIMEIRA_VD;
import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ConsultoriaService {

    private final PacienteRepository pacienteRepository;
    private final EquipeRepository equipeRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConsultoriaRepository consultoriaRepository;

    @Transactional
    public void criarConsultoria(@Valid ConsultoriaRequest request) {
        var paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        var usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var equipe = equipeRepository.findById(request.getEquipeId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        consultoriaRepository.save(
                ConsultoriaMapper.fromRequest(request, usuario, paciente, equipe)
        );
    }

    @Transactional
    public void registrarBaixa(Long id, @Valid ConsultoriaRequest request) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        consultoria.setStatusSala(request.getStatusSala());
        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setStatusConsultoria(false);
    }

    public ConsultoriaResponse buscarConsultoriaPorId(Long id) {
        return consultoriaRepository.findById(id)
                .map(ConsultoriaMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));
    }

    @Transactional
    public void atualizarEquipe(Long id, ConsultoriaRequest request) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        var equipe = equipeRepository.findById(request.getEquipeId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Equipe não encontrada"));

        consultoria.setEquipe(equipe);
        consultoria.setStatusSala(AGUARDANDO_DISCUSSAO_EMADS);
    }

    @Transactional
    public void atualizarDadosConsultoria(Long id, ConsultoriaRequest request) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        consultoria.setUnidadeSaude(request.getUnidadeSaude());
        consultoria.setDataConsultoria(request.getDataConsultoria());
        consultoria.setSolicitante(request.getSolicitante());

        ofNullable(request.getStatusBaixa())
                .ifPresent(status -> {
                    consultoria.setStatusBaixa(status);
                    consultoria.setStatusConsultoria(false);
                });

        ofNullable(request.getModalidadeVisita())
                .ifPresent(consultoria::setModalidadeVisita);
    }

    public Page<ConsultoriaResponse> listarConsultoriasBaixadas(Pageable pageable) {
        return consultoriaRepository.findByStatusConsultoriaFalse(pageable)
                .map(ConsultoriaMapper::toResponse);
    }

    @Transactional
    public void registrarBaixaHospitalar(Long id, @Valid ConsultoriaRequest request) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setStatusSala(request.getStatusSala());
        consultoria.setStatusConsultoria(false);
        consultoria.setHospital(request.getHospital());
    }


    @Transactional
    public void atualizarModalidadeVisita(Long id, @Valid ConsultoriaRequest request) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        consultoria.setModalidadeVisita(request.getModalidadeVisita());
    }

    @Transactional
    public void atualizarStatusSala(@Valid ConsultoriaRequest request, Long id) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        consultoria.setStatusSala(request.getStatusSala());
    }

    public List<ConsultoriaResponse> listarConsultoriasAtivasPorEquipe(Long equipeId) {
        return consultoriaRepository.findByEquipeId(equipeId).stream()
                .map(ConsultoriaMapper::toResponse)
                .filter(ConsultoriaResponse::isStatusConsultoria)
                .toList();
    }

    public List<ConsultoriaResponse> listarConsultoriasPendentesPrimeiraVisitaPorEquipe(Long equipeId) {
        return consultoriaRepository.findByEquipeId(equipeId).stream()
                .filter(c -> c.isStatusConsultoria()
                        && c.getStatusSala() == AGUARDANDO_PRIMEIRA_VD
                        && c.getModalidadeVisita() != null)
                .map(ConsultoriaMapper::toResponse)
                .toList();
    }

    @Transactional
    public void registrarBaixaComSituacoesEspecificas(Long id, @Valid ConsultoriaRequest request) {
        var consultoria = consultoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Consultoria não encontrada"));

        consultoria.setStatusConsultoria(false);
        consultoria.setStatusBaixa(request.getStatusBaixa());
        consultoria.setSituacoesEspecificas(request.getSituacoesEspecificas());
    }

}
