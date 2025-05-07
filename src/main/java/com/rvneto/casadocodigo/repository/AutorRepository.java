package com.rvneto.casadocodigo.repository;

import com.rvneto.casadocodigo.domain.model.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorRepository {

    public Autor buscarPorNome(EntityManager manager, String nome) {
        String jpql = "SELECT c FROM Autor c WHERE c.nome = :nome";
        TypedQuery<Autor> query = manager.createQuery(jpql, Autor.class);
        query.setParameter("nome", nome);
        List<Autor> autores = query.getResultList();
        if (!autores.isEmpty()) {
            return autores.getFirst();
        }
        return null;
    }

}
