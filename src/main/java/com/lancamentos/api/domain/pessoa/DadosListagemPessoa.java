package com.lancamentos.api.domain.pessoa;

public record DadosListagemPessoa(
        Long codigo,
        String nome) {

    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getCodigo(), pessoa.getNome());
    }
}
