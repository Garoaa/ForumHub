package br.com.forumhub.ForumHub.Domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(

        @NotBlank

        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String mensagem,
        @NotBlank
        String curso
) {
}
