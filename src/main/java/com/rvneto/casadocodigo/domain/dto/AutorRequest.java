package com.rvneto.casadocodigo.domain.dto;

import com.rvneto.casadocodigo.domain.model.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail deve ser válido")
    private String email;

    @NotBlank(message = "Descrição é obrigatório")
    @Size(max = 400, message = "A descrição deve conter no máximo 400 caracteres")
    private String descricao;

    public Autor toModel() {
        return Autor.builder()
                .nome(this.nome)
                .descricao(this.nome)
                .email(this.email)
                .build();
    }

}
