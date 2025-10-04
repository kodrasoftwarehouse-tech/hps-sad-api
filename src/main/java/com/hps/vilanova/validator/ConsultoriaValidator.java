package com.hps.vilanova.validator;

import com.hps.vilanova.repository.ConsultoriaRepository;
import com.hps.vilanova.repository.EquipeRepository;
import com.hps.vilanova.repository.PacienteRepository;
import com.hps.vilanova.repository.UsuarioRepository;
import com.hps.vilanova.service.consultoria.ConsultoriaService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class ConsultoriaValidator {
    private ConsultoriaService consultoriaService;
    private EquipeRepository equipeRepository;
    private UsuarioRepository usuarioRepository;
    private PacienteRepository pacienteRepository;
    private static ConsultoriaRepository consultoriaRepository;

    public static void validateEquipeId(Long equipeId){
        if(equipeId == null){
            throw new ResponseStatusException(BAD_REQUEST, "O ID" + equipeId + "não é valido");
        }
    }

    public static void validateUsuarioId(Long usuarioId){
        if(usuarioId == null){
            throw new ResponseStatusException(BAD_REQUEST, "O ID" + usuarioId + "não é valido");
        }
    }

    public static void validateConsultoriaId(Long consultoriaId){
        if(consultoriaId == null){
            throw new ResponseStatusException(BAD_REQUEST, "O ID" + consultoriaId + "não é valido");
        }
    }


    public static void validatePacienteId(Long pacienteId){
        if(pacienteId == null){
            throw new ResponseStatusException(BAD_REQUEST, "O ID" + pacienteId + "não é valido");
        }
    }



}
