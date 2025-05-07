package com.rvneto.casadocodigo.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.BadRequestException;

import java.time.LocalDate;

import static java.util.Objects.isNull;

@Entity
@Getter
@Setter
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false)
    private String resumo;
    private String sumario;
    @Column(nullable = false)
    private float preco;
    @Column(nullable = false)
    private Integer paginas;
    @Column(nullable = false, unique = true)
    private String isbn;
    private LocalDate dataPublicacao;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    public void atualizaAutorECategoria(Autor autor, Categoria categoria) throws BadRequestException {
        if (isNull(autor)) {
            throw new BadRequestException("Autor não informado ou não encontrado");
        }
        if (isNull(categoria)) {
            throw new BadRequestException("Categoria não informada ou não encontrada");
        }
        this.autor = autor;
        this.categoria = categoria;
    }

}
