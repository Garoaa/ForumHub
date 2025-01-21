package br.com.forumhub.ForumHub.controller;

import br.com.forumhub.ForumHub.Domain.topico.*;
import br.com.forumhub.ForumHub.infra.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        if (repository.existsByTitulo(dados.titulo())){
            throw new ValidacaoException("Esse título já existe!");
        }
        if (repository.existsByMensagem(dados.mensagem())){
            throw new ValidacaoException("Essa mensagem já existe!");
        }

        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC)Pageable pageable){
        var page = repository.findAll(pageable).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarTopico dados){
        var topico = repository.getReferenceById(id);
        topico.atualizarTopico(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
