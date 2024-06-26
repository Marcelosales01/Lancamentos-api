package com.lancamentos.api.domain.lancamento;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemLancamento (
        Long codigo,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        String categoria,
        String pessoa
) {
    public DadosListagemLancamento(Lancamento lancamento) {
        this(
                lancamento.getCodigo(),
                lancamento.getDescricao(),
                lancamento.getDataVencimento(),
                lancamento.getDataPagamento(),
                lancamento.getValor(),
                lancamento.getObservacao(),
                lancamento.getTipo(),
                lancamento.getCategoria().getNome(),
                lancamento.getPessoa().getNome()
        );
    }
}
