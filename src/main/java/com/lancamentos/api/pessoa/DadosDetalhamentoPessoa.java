package com.lancamentos.api.pessoa;

import com.lancamentos.api.endereco.Endereco;

public record DadosDetalhamentoPessoa(
        Long codigo, String nome,
        Endereco endereco) {

    public DadosDetalhamentoPessoa (Pessoa pessoa){
        this(pessoa.getCodigo(),
                pessoa.getNome(),
                pessoa.getEndereco());
    }
}
