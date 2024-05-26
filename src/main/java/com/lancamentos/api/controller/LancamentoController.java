package com.lancamentos.api.controller;
import com.lancamentos.api.domain.categoria.Categoria;
import com.lancamentos.api.domain.categoria.CategoriaRepository;
import com.lancamentos.api.domain.lancamento.*;


import com.lancamentos.api.domain.pessoa.Pessoa;
import com.lancamentos.api.domain.pessoa.PessoaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoRepository repository;
    @Autowired
    private CategoriaRepository CategoriaRepository;

    @Autowired
    private PessoaRepository PessoaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder){
        Categoria categoria = CategoriaRepository.findById(dados.codigo_categoria())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada"));
        Pessoa pessoa = PessoaRepository.findById(dados.codigo_pessoa())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));

        var lancamento = new Lancamento(dados, categoria, pessoa);
        repository.save(lancamento);

        var uri = uriBuilder.path("/lancamentos/{codigo}").buildAndExpand(lancamento.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoLancamento(lancamento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>> listar(@PageableDefault(size = 10, sort = {"codigo"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = repository.getReferenceById(dados.codigo());
        lancamento.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var lancamento = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));

    }





}
