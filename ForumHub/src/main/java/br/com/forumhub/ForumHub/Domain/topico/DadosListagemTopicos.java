package br.com.forumhub.ForumHub.Domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosListagemTopicos(String titulo, String mensagem, LocalDateTime dataCriacao, Status status, String autor, String curso) {

    public DadosListagemTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
