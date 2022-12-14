package com.setup.gerenciador_de_produtos.service;

import com.setup.gerenciador_de_produtos.model.Usuario;
import com.setup.gerenciador_de_produtos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public void saveUsuario(Usuario usuario) {
        this.repository.save(usuario);
    }

    @Transactional
    public Optional<Usuario> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Transactional
    public Usuario findById(Long id) {
        Usuario usuario = new Usuario();
        if(this.repository.findById(id).isPresent())
            usuario = this.repository.findById(id).get();
        return usuario;
    }
    @Transactional
    public List<Usuario> findAll() {
        return this.repository.findAll();
    }
}
