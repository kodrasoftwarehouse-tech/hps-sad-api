package com.hps.vilanova.service.veiculo;

import com.hps.vilanova.controller.response.corrida.CorridaResponse;
import com.hps.vilanova.mapper.corrida.CorridaMapper;
import com.hps.vilanova.model.Corrida;
import com.hps.vilanova.repository.CorridaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class VeiculoBuscarHistorioService {

    private final CorridaRepository corridaRepository;

    public Page<CorridaResponse> buscarHistorico(Long veiculoId, LocalDate dataInicial, LocalDate dataFinal, Pageable pageable) {

        if(dataInicial == null && dataFinal == null){
            return corridaRepository.findByVeiculoId(veiculoId,pageable)
                    .map(CorridaMapper::toDetalheResponse);
        }
                return corridaRepository.findByVeiculoIdAndDataCorridaBetween(veiculoId, dataInicial, dataFinal, pageable)
                .map(CorridaMapper::toDetalheResponse);

    }

}
