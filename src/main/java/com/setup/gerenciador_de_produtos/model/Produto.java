package com.setup.gerenciador_de_produtos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(schema = "public", name = "produtos")
@NoArgsConstructor
public class Produto extends AbstractEntity {

    @Getter @Setter
    private Long donoId;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private String categoria;

    @Getter @Setter
    private String preco;

    @Getter @Setter
    private String quantidade;

    @Getter @Setter
    private String imagem;

}
