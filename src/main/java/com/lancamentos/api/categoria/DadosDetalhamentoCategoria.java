package com.lancamentos.api.categoria;

public record DadosDetalhamentoCategoria(
        Long codigo,
        String nome
) {

    public DadosDetalhamentoCategoria (Categoria categoria){
        this(categoria.getCodigo(), categoria.getNome());
    }
}
