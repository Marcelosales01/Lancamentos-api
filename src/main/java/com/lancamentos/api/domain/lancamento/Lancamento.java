package com.lancamentos.api.domain.lancamento;

import com.lancamentos.api.domain.categoria.Categoria;
import com.lancamentos.api.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Table(name = "Lancamento")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private BigDecimal valor;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;

    public Lancamento(DadosCadastroLancamento dados, Categoria categoria, Pessoa pessoa) {
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.tipo = dados.tipo();
        this.categoria = categoria;
        this.pessoa = pessoa;


    }

    public void atualizarInformacoes(DadosAtualizacaoLancamento dados) {
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.dataVencimento() != null){
            this.dataVencimento = dados.dataVencimento();
        }
        if (dados.dataPagamento() != null){
            this.dataPagamento = dados.dataPagamento();
        }
        if (dados.valor() != null){
            this.valor = dados.valor();
        }
        if (dados.observacao() != null){
            this.observacao = dados.observacao();
        }
        if (dados.dataVencimento() != null){
            this.tipo = dados.tipo();
        }
        if (categoria != null){
            this.categoria = categoria;
        }
        if (pessoa != null){
            this.pessoa = pessoa;
        }

    }

}
