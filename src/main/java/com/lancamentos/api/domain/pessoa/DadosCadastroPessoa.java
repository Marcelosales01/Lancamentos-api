package com.lancamentos.api.domain.pessoa;

import com.lancamentos.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotNull
        @Valid
        DadosEndereco endereco

) {

}
