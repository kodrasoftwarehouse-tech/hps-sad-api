package com.hps.vilanova.controller.request.consultoria;

import com.hps.vilanova.model.enums.StatusBaixa;
import com.hps.vilanova.model.enums.StatusSala;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsultoriaHospitalBaixaRequest {

    private StatusSala statusSala;

    private StatusBaixa statusBaixa;

    private String hospital;
}
