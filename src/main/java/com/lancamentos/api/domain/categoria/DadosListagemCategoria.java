package com.lancamentos.api.domain.categoria;

public record DadosListagemCategoria(Long codigo,
                                     String nome) {

    public DadosListagemCategoria(Categoria categoria){
        this(categoria.getCodigo(),
                categoria.getNome());
    }
}
