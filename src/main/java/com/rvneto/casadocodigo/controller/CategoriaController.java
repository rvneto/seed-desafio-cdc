package com.rvneto.casadocodigo.controller;

import com.rvneto.casadocodigo.domain.dto.AutorRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void cadastrar(@Valid @RequestBody AutorRequest request) {
        manager.persist(request.toModel());
    }

}
