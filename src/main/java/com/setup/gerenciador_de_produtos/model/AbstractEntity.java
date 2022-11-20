package com.setup.gerenciador_de_produtos.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(name = "cadastro")
    private LocalDateTime cadastro;

    @Column(name = "atualizado")
    private LocalDateTime atualizado;

    @Column(name = "excluido")
    private LocalDateTime excluido;

    @PrePersist
    public void dataCadastro() {
        this.atualizado = LocalDateTime.now();
    }

    @PreUpdate
    public void dataAtualizacao() {
        this.atualizado = LocalDateTime.now();
    }
}

