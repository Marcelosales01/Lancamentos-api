package com.lancamentos.api.controller;
import com.lancamentos.api.lancamento.*;


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
@RequestMapping("lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroLancamento dados){
        repository.save(new Lancamento(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>> listar(@PageableDefault(size = 10, sort = {"codigo"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }





}
