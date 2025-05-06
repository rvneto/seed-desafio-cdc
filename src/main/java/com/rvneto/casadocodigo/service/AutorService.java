package com.rvneto.casadocodigo.service;

import com.rvneto.casadocodigo.domain.dto.AutorRequest;
import com.rvneto.casadocodigo.domain.model.Autor;
import com.rvneto.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public void cadastrar(AutorRequest request) {
        repository.save(new Autor(request));
    }

}
