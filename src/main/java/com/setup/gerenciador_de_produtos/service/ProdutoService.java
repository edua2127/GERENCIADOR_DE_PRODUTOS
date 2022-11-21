package com.setup.gerenciador_de_produtos.service;

import com.setup.gerenciador_de_produtos.model.Produto;
import com.setup.gerenciador_de_produtos.repository.ProdutoRepository;
import com.setup.gerenciador_de_produtos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    public ProdutoService(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository) {
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void salvarProduto(Produto produto) {
        if (verificacaoSeODonoDoProdutoExiste(produto)) {
            System.out.println("Dono do produto foi encontrado");
            produtoRepository.save(produto);
        } else throw new RuntimeException("O dono do produto não existe");
    }

    public boolean verificacaoSeODonoDoProdutoExiste(@NotNull @org.jetbrains.annotations.NotNull Produto produto) {
        return usuarioRepository.findById(produto.getDonoId()).isPresent();
    }

    @Transactional
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    @Transactional
    public void atualizarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Transactional
    public Produto findById(Long id) {
        Produto produto;
        if (this.produtoRepository.findById(id).isPresent()) {
            produto = this.produtoRepository.findById(id).get();
            return produto;
        } else {
            return null;
        }
    }

    @Transactional
    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }

}
