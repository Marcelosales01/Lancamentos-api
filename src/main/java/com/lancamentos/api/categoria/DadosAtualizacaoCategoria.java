package com.lancamentos.api.categoria;

import com.lancamentos.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(
        @NotNull
        Long codigo,
        @NotBlank
        String nome) {
}
