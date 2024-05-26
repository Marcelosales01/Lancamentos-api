package com.lancamentos.api.domain.lancamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
public record DadosCadastroLancamento(

        @NotBlank
        String descricao,

        LocalDate dataVencimento,
        LocalDate dataPagamento,

        @NotNull
        BigDecimal valor,

        String observacao,

        @NotNull
        @Valid
        TipoLancamento tipo,

        @NotNull
        Long codigo_categoria,

        @NotNull
        Long codigo_pessoa) {


}

