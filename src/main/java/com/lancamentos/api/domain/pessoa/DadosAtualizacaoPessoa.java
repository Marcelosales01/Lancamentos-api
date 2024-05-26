package com.lancamentos.api.domain.pessoa;

import com.lancamentos.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long codigo,
        String nome,
        DadosEndereco endereco) {
}
