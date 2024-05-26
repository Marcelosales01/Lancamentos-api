package com.lancamentos.api.domain.pessoa;

import com.lancamentos.api.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(
        Long codigo, String nome,
        Endereco endereco) {

    public DadosDetalhamentoPessoa (Pessoa pessoa){
        this(pessoa.getCodigo(),
                pessoa.getNome(),
                pessoa.getEndereco());
    }
}
