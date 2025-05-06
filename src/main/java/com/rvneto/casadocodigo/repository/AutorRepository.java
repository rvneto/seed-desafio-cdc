package com.rvneto.casadocodigo.repository;

import com.rvneto.casadocodigo.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
