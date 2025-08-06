package com.hps.vilanova.service.corrida;

import com.hps.vilanova.model.Veiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class calculaKmRodado {

    public static Veiculo calculo(Veiculo veiculo, BigDecimal kmInicial, BigDecimal kmFinal) {
        BigDecimal kmRodado = kmFinal.subtract(kmInicial);
        BigDecimal kmRodadoAtual = veiculo.getKmRodado();
        BigDecimal kmRodadoTotal = kmRodadoAtual.add(kmRodado);

        veiculo.setKmRodado(kmRodadoTotal);
        veiculo.setKmAtual(kmFinal);

        return veiculo;
    }
}
