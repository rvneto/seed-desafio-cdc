package com.rvneto.casadocodigo.controller;

import com.rvneto.casadocodigo.domain.dto.LivroRequest;
import com.rvneto.casadocodigo.domain.model.Autor;
import com.rvneto.casadocodigo.domain.model.Categoria;
import com.rvneto.casadocodigo.domain.model.Livro;
import com.rvneto.casadocodigo.repository.AutorRepository;
import com.rvneto.casadocodigo.repository.CategoriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void cadastrar(@Valid @RequestBody LivroRequest request) throws BadRequestException {
        Livro livro = request.toModel();
        Autor autor = autorRepository.buscarPorNome(manager, request.getAutor());
        Categoria categoria = categoriaRepository.buscarPorDescricao(manager, request.getCategoria());
        livro.atualizaAutorECategoria(autor, categoria);
        manager.persist(livro);
    }

}
