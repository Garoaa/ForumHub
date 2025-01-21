package br.com.forumhub.ForumHub.Domain.topico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;



import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Topico {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String titulo;
    @Column(unique = true, nullable = false)
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;
    private String curso;

    public Topico(){}


    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.status = Status.ATIVO;
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public void atualizarTopico(DadosAtualizarTopico dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.autor() != null){
            this.autor = dados.autor();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null){
            this.curso = dados.curso();
        }
    }
}
