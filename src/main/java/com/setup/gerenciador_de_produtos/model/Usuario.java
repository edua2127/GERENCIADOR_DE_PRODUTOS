package com.setup.gerenciador_de_produtos.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity(name = "usuarios")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Usuario extends AbstractEntity {
    @Column(unique = true)
    private String username;

    private String email;

    private String password;
}
