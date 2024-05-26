package com.lancamentos.api.domain.categoria;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;

    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
    }


    public void atualizarInformacoes(DadosAtualizacaoCategoria dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
    }
}
