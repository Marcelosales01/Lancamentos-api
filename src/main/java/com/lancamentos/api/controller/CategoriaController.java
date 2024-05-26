package com.lancamentos.api.controller;

import com.lancamentos.api.domain.categoria.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder){
        var categoria = new Categoria(dados);
        repository.save(categoria);
        var uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCategoria(categoria));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoria>> listar(@PageableDefault(size = 10, sort = {"codigo"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemCategoria::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCategoria dados){
        var categoria = repository.getReferenceById(dados.codigo());
        categoria.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var categoria = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));

    }
}
