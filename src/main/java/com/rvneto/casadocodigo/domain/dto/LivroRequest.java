package com.rvneto.casadocodigo.domain.dto;

import com.rvneto.casadocodigo.domain.model.Livro;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LivroRequest {

    @NotBlank(message = "Titulo é obrigatório")
    private String titulo;
    @NotBlank(message = "Resumo é obrigatório")
    @Size(min = 1, max = 500)
    private String resumo;
    private String sumario;
    @NotNull(message = "Preço é obrigatório")
    private float preco;
    @NotNull(message = "Paginas é obrigatório")
    @Min(100)
    private int paginas;
    private String isbn;
    @Future(message = "A data precisa estar no futuro")
    private LocalDate dataPublicacao;
    @NotBlank(message = "Categoria é obrigatório")
    private String categoria;
    @NotBlank(message = "Autor é obrigatório")
    private String autor;

    public Livro toModel() {
        return Livro.builder()
                .titulo(this.titulo)
                .resumo(this.resumo)
                .sumario(this.sumario)
                .preco(this.preco)
                .paginas(this.paginas)
                .isbn(this.isbn)
                .dataPublicacao(this.dataPublicacao)
                .build();

    }

}
