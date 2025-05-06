package com.rvneto.casadocodigo.controller;

import com.rvneto.casadocodigo.domain.dto.AutorRequest;
import com.rvneto.casadocodigo.service.AutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
@AllArgsConstructor
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastrar(@Valid @RequestBody AutorRequest request) {
        service.cadastrar(request);
    }

}
