package com.lancamentos.api.pessoa;

import com.lancamentos.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long codigo,
        String nome,
        DadosEndereco endereco) {
}
