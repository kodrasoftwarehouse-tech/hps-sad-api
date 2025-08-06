package com.hps.vilanova.service.corrida;


import com.hps.vilanova.controller.request.corrida.CorridaFinalizarRequest;
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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class CorridaFinalizarservice {

    private final VisitaRepository visitaRepository;
    private final VeiculoRepository veiculoRepository;
    private final PosicaoRepository posicaoRepository;
    private final CorridaRepository corridaRepository;

    @Transactional
    public void finalizar(Long id, CorridaFinalizarRequest request) {
        Corrida corrida = corridaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Corrida não encontrada"));

        Visita visita = visitaRepository.findByCorridaId(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Visita não encontrada"));

        Veiculo veiculo = veiculoRepository.findById(corrida.getVeiculo().getId())
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Veiculo não encontrado"));

        if(visita.getStatusVisita() == StatusVisita.CONSULTORIA_A_CAMINHO){
            visita.setStatusVisita(StatusVisita.CONSULTORIA_CORRIDA_FINALIZADA);
        } else if (visita.getStatusVisita() == StatusVisita.A_CAMINHO) {
            visita.setStatusVisita(StatusVisita.CORRIDA_FINALIZADA);
        }
        visitaRepository.saveAndFlush(visita);

        Posicao posicao = PosicaoMapper.toEntity(request.getPosicaoFinal());
        posicaoRepository.saveAndFlush(posicao);

        Veiculo veiculoAtualizado = calculaKmRodado.calculo(veiculo, corrida.getKmInicial(), request.getKmFinal());
        veiculoRepository.saveAndFlush(veiculoAtualizado);

        corrida.setKmFinal(request.getKmFinal());
        corrida.setHoraFinal(LocalTime.now());
        corrida.setDataCorrida(LocalDate.now());
        corrida.setPosicaoFinal(posicao);
        corrida.setStatusCorrida(StatusCorrida.ENCERRADA);

        corridaRepository.save(corrida);
    }
}
