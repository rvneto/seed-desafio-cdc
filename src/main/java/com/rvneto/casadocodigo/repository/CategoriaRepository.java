package com.rvneto.casadocodigo.repository;

import com.rvneto.casadocodigo.domain.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {

    public Categoria buscarPorDescricao(EntityManager manager, String descricao) {
        String jpql = "SELECT c FROM Categoria c WHERE c.descricao = :descricao";
        TypedQuery<Categoria> query = manager.createQuery(jpql, Categoria.class);
        query.setParameter("descricao", descricao);
        List<Categoria> categorias = query.getResultList();
        if (!categorias.isEmpty()) {
            return categorias.getFirst();
        }
        return null;
    }

}
