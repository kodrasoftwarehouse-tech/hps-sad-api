package com.hps.vilanova.service.visita;

import com.hps.vilanova.dto.request.relatorio.RelatorioRequest;
import com.hps.vilanova.dto.request.relatorio.RelatorioUsuarioRequest;
import com.hps.vilanova.mapper.relatorio.RelatorioMapper;
import com.hps.vilanova.model.Relatorio;
import com.hps.vilanova.model.RelatorioUsuario;
import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.Visita;
import com.hps.vilanova.model.enums.StatusVisita;
import com.hps.vilanova.repository.RelatorioRepository;
import com.hps.vilanova.repository.RelatorioUsuarioRepository;
import com.hps.vilanova.repository.UsuarioRepository;
import com.hps.vilanova.repository.VisitaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class VisitaEncerrarService {

    private final VisitaRepository visitaRepository;
    private final RelatorioRepository relatorioRepository;
    private final RelatorioUsuarioRepository relatorioUsuarioRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public void encerrar(Long VisitaId, RelatorioRequest request) {
        Relatorio relatorio = RelatorioMapper.toEntity(request);
        relatorioRepository.saveAndFlush(relatorio);

        for (RelatorioUsuarioRequest rel : request.getUsuarios()) {
            Usuario usuario = usuarioRepository.findById(rel.getUsuarioId())
                    .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuario não encontrado"));

            RelatorioUsuario relatorioUsuario = new RelatorioUsuario(relatorio, usuario);
            relatorioUsuarioRepository.saveAndFlush(relatorioUsuario);
        }

        Visita visita = visitaRepository.findById(VisitaId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Visita não encontrada"));

        visita.setRelatorio(relatorio);
        visita.setStatusVisita(StatusVisita.ENCERRADA);

        visitaRepository.save(visita);
    }
}
