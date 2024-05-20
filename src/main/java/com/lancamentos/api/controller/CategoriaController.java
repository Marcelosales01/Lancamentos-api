package com.lancamentos.api.controller;

import com.lancamentos.api.categoria.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCategoria dados){
        repository.save(new Categoria(dados));
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
}
