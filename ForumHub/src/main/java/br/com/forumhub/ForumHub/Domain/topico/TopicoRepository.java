package br.com.forumhub.ForumHub.Domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


    boolean existsByMensagem(@NotBlank String mensagem);

    boolean existsByTitulo(@NotBlank String titulo);
}
