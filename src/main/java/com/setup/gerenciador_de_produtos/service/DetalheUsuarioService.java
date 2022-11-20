package com.setup.gerenciador_de_produtos.service;

import com.setup.gerenciador_de_produtos.model.Usuario;
import com.setup.gerenciador_de_produtos.data.DetalheUsuarioData;
import com.setup.gerenciador_de_produtos.repository.UsuarioRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //faz com que esse seja gerenciado pelo spring secuty
public class DetalheUsuarioService implements UserDetailsService{
    private final UsuarioRepository repository;

    public DetalheUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = this.repository.findByUsername(username);

        if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("usuario não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }
}
