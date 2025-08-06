package com.hps.vilanova.service.corrida;

import com.hps.vilanova.controller.request.corrida.CorridaCadastroRequest;
import com.hps.vilanova.controller.response.corrida.CorridaCadastroResponse;
import com.hps.vilanova.controller.response.corrida.CorridaResponse;
import com.hps.vilanova.mapper.corrida.CorridaMapper;
import com.hps.vilanova.mapper.posicao.PosicaoMapper;
import com.hps.vilanova.model.*;
import com.hps.vilanova.model.enums.StatusCorrida;
import com.hps.vilanova.model.enums.StatusVisita;
import com.hps.vilanova.model.enums.TipoCorrida;
import com.hps.vilanova.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class CorridaCadastrarService {

    private final UsuarioRepository usuarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final PosicaoRepository posicaoRepository;
    private final CorridaRepository corridaRepository;
    private final VisitaRepository visitaRepository;

    @Transactional
    public CorridaCadastroResponse cadastrar(Long visitaId, CorridaCadastroRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Usuario não encontrado"));
        Veiculo veiculo = veiculoRepository.findById(request.getVeiculoId())
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Veiculo não encontrado"));

        if (veiculo.getKmAtual().compareTo(request.getKmInicial()) < 0) {
            veiculo.setKmAtual(request.getKmInicial());

            BigDecimal diferenca = request.getKmInicial().subtract(veiculo.getKmAtual());
            if (diferenca.compareTo(BigDecimal.ZERO) > 0) {
                veiculo.setKmRodado(veiculo.getKmRodado().add(diferenca));
            }
        }

        veiculoRepository.saveAndFlush(veiculo);

        Posicao posicao = PosicaoMapper.toEntity(request.getPosicaoInicial());
        posicaoRepository.saveAndFlush(posicao);

        Corrida corrida = CorridaMapper.toEntity(request,posicao, usuario, veiculo);
        corrida.setStatusCorrida(StatusCorrida.INICIADA);

        if(request.getTipoCorrida() == TipoCorrida.OUTROS){
            corrida.setOutrosDescricao(request.getOutrosDescricao());
        }

        corridaRepository.saveAndFlush(corrida);

        Visita visita = visitaRepository.findById(visitaId)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"visita não encontrada"));

        visita.setCorrida(corrida);
        if(visita.getStatusVisita() == StatusVisita.CONSULTORIA_AGENDADA){
            visita.setStatusVisita(StatusVisita.CONSULTORIA_A_CAMINHO);
        } else if (visita.getStatusVisita() == StatusVisita.AGENDADA) {
            visita.setStatusVisita(StatusVisita.A_CAMINHO);
        }

        visitaRepository.save(visita);

        return CorridaMapper.toResponse(corrida);
    }

}
