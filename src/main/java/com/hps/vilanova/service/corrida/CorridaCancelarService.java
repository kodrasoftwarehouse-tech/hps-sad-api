package com.hps.vilanova.service.corrida;

import com.hps.vilanova.dto.request.corrida.CorridaCancelarRequest;
import com.hps.vilanova.mapper.posicao.PosicaoMapper;
import com.hps.vilanova.model.Corrida;
import com.hps.vilanova.model.Posicao;
import com.hps.vilanova.model.Veiculo;
import com.hps.vilanova.model.Visita;
import com.hps.vilanova.model.enums.StatusCorrida;
import com.hps.vilanova.model.enums.StatusVisita;
import com.hps.vilanova.repository.CorridaRepository;
import com.hps.vilanova.repository.PosicaoRepository;
import com.hps.vilanova.repository.VeiculoRepository;
import com.hps.vilanova.repository.VisitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class CorridaCancelarService {

    private final CorridaRepository corridaRepository;
    private final VisitaRepository visitaRepository;
    private final PosicaoRepository posicaoRepository;
    private final VeiculoRepository veiculoRepository;

    public void cancelar(Long id, CorridaCancelarRequest request) {
        Corrida corrida = corridaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Corrida não encontrada!"));

        Visita visita = visitaRepository.findByCorridaId(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Visita não encontrada"));

        Veiculo veiculo = veiculoRepository.findById(corrida.getVeiculo().getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Veiculo não encontrado!"));

        Posicao posicao = PosicaoMapper.toEntity(request.getPosicaoFinal());
        posicaoRepository.saveAndFlush(posicao);


        corrida.setStatusCorrida(StatusCorrida.ENCERRADA);
        corrida.setPosicaoFinal(posicao);
        corrida.setHoraFinal(LocalTime.now());
        corrida.setKmFinal(request.getKmFinal());
        corrida.setMotivoCancelamento(request.getMotivoCancelamento());

        if (visita.getStatusVisita() == StatusVisita.A_CAMINHO) {
            visita.setStatusVisita(StatusVisita.AGENDADA);
        } else if (visita.getStatusVisita() == StatusVisita.CONSULTORIA_A_CAMINHO) {
            visita.setStatusVisita(StatusVisita.CONSULTORIA_AGENDADA);
        }
        visita.setCorrida(null);
        visitaRepository.saveAndFlush(visita);


        Veiculo veiculoAtualizado = calculaKmRodado.calculo(veiculo, corrida.getKmInicial(), request.getKmFinal());
        veiculoRepository.saveAndFlush(veiculoAtualizado);

        corridaRepository.save(corrida);
    }
}
