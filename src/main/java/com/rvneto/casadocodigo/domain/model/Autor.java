package com.rvneto.casadocodigo.domain.model;

import com.rvneto.casadocodigo.domain.dto.AutorRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dthRegistro;

    public Autor(AutorRequest request) {
        this.nome = request.getNome();
        this.email = request.getEmail();
        this.descricao = request.getDescricao();
        this.dthRegistro = LocalDateTime.now();
    }
}
