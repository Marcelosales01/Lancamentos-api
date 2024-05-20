package com.lancamentos.api.categoria;

import com.lancamentos.api.endereco.DadosEndereco;
import com.lancamentos.api.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(
        @NotNull
        @Size(min = 3, max = 20)
        String nome) {

}
