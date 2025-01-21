package br.com.forumhub.ForumHub.Domain.topico;

public record DadosDetalhamentoTopico(Long id, String titulo, String autor, String mensagem, String curso, Status status) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getAutor(), topico.getCurso(), topico.getMensagem(), topico.getStatus());
    }
}
