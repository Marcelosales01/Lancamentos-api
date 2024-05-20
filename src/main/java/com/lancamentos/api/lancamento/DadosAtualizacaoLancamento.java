package com.lancamentos.api.lancamento;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLancamento(
        Long codigo,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        Long categoriaId,
        Long pessoaId
) {}
