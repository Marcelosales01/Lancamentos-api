package com.lancamentos.api.domain.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(
        @NotNull
        Long codigo,
        @NotBlank
        String nome) {
}
