package com.lancamentos.api.domain.lancamento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLancamento(
        @NotNull
        Long codigo,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        Long categoriaId,
        Long pessoaId) {}
