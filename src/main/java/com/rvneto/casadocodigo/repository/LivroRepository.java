package com.rvneto.casadocodigo.repository;

import com.rvneto.casadocodigo.domain.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepository {

    public List<Livro> buscar(EntityManager manager) {
        String jpql = "SELECT l FROM Livro l";
        TypedQuery<Livro> query = manager.createQuery(jpql, Livro.class);
        return query.getResultList();
    }

}
