package com.hps.vilanova.validation;

import com.hps.vilanova.dto.request.consultoria.ConsultoriaRequest;
import com.hps.vilanova.dto.request.consultoria.ConsultoriaUpdateRequest;
import com.hps.vilanova.exceptions.ValidationException;
import jakarta.validation.Valid;

import java.time.LocalDate;

public class ConsultoriaValidator {

    public static void validateForCreate(ConsultoriaRequest request) {
        checkNotNullOrBlank(request, "Dados da consultoria não podem ser nulos");
        checkNotNull(request.getPacienteId(), "Paciente é obrigatório");
        checkNotNull(request.getUsuarioId(), "Usuário é obrigatório");
        checkNotNull(request.getEquipeId(), "Equipe é obrigatória");
        checkNotNullOrBlank(request.getUnidadeSaude(), "Unidade de saúde é obrigatória");
        checkNotNull(request.getDataConsultoria(), "Data da consultoria é obrigatória");
        checkDateNotPast(request.getDataConsultoria(), "Data da consultoria não pode ser no passado");
        checkNotNullOrBlank(request.getSolicitante(), "Solicitante é obrigatório");
    }

    public static void validateForUpdate(@Valid ConsultoriaUpdateRequest request){
        checkNotNull(request, "Dados da consultoria não podem ser nulos");
        checkNotNull(request.getId(), "ID da consultoria é obrigatório para atualização");
        if (request.getUnidadeSaude() != null) {
            checkNotNullOrBlank(request.getUnidadeSaude(), "Unidade de saúde não pode ser vazia");
        }
        if (request.getDataConsultoria() != null) {
            checkDateNotPast(request.getDataConsultoria(), "Data da consultoria não pode ser no passado");
        }
        if (request.getSolicitante() != null) {
            checkNotNullOrBlank(request.getSolicitante(), "Solicitante não pode ser vazio");
        }
    }

    public static void validateForSearch(Long id) {
        checkNotNull(id, "ID da consultoria é obrigatório para busca");
    }

    public static void validateForDelete(Long id) {
        checkNotNull(id, "ID da consultoria é obrigatório para exclusão");
    }

    private static void checkNotNullOrBlank(Object obj, String message) {
        if (obj == null) {
            throw new ValidationException(message, 400);
        }
        if (obj instanceof String && ((String) obj).isBlank()) {
            throw new ValidationException(message, 400);
        }
    }

    private static void checkNotNull(Object obj, String message) {
        if (obj == null) {
            throw new ValidationException(message, 400);
        }
    }

    private static void checkDateNotPast(LocalDate date, String message) {
        if (date.isBefore(LocalDate.now())) {
            throw new ValidationException(message, 400);
        }
    }
}
