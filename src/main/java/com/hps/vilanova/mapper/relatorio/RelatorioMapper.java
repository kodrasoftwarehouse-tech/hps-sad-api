package com.hps.vilanova.mapper.relatorio;

import com.hps.vilanova.dto.request.relatorio.RelatorioRequest;
import com.hps.vilanova.model.Relatorio;

public class RelatorioMapper {


    public static Relatorio toEntity(RelatorioRequest request) {
        return Relatorio.builder()
                .agudizou(request.isAgudizou())
                .intercorreu(request.isIntercorreu())
                .internacaoEvitada(request.isInternacaoEvitada())
                .dataRelatorio(request.getDataRelatorio())
                .observacoes(request.getObservacoes())
                .build();
    }
}
