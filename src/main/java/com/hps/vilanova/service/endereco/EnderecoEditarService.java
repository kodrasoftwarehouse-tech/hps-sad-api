package com.hps.vilanova.service.endereco;

import com.hps.vilanova.controller.request.endereco.EnderecoRequest;
import com.hps.vilanova.model.Endereco;
import com.hps.vilanova.repository.EnderecoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@Service
public class EnderecoEditarService {

    private final EnderecoRepository enderecoRepository;


    public void editar(Long id, @Valid EnderecoRequest request) {

        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(NOT_FOUND,"Endereço não encontrado"));

        endereco.setCep(request.getCep());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setComplemento(request.getComplemento());
        endereco.setNumero(request.getNumero());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());

        enderecoRepository.save(endereco);

    }
}
