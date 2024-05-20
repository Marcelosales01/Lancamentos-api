package com.lancamentos.api.lancamento;
import com.lancamentos.api.categoria.DadosCadastroCategoria;
import com.lancamentos.api.pessoa.DadosCadastroPessoa;
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

        @NotBlank
        String categoria,
        @NotBlank
        String pessoa,

        @NotNull
        Long categoriaCodigo,

        @NotNull
        Long pessoaCodigo
) {


}

