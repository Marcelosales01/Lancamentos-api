package com.lancamentos.api.domain.categoria;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(
        @NotNull
        @Size(min = 3, max = 20)
        String nome) {

}
