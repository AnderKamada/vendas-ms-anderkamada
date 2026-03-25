package br.com.fiap.vendasms.service;

import br.com.fiap.vendasms.entities.Produto;
import br.com.fiap.vendasms.exception.ProdutoNaoEncontradoException;
import br.com.fiap.vendasms.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {

        if (produto.getId() != null && repository.existsById(produto.getId())) {

            Produto existente = repository.findById(produto.getId()).get();

            existente.setNome(produto.getNome());
            existente.setDescricao(produto.getDescricao());
            existente.setPreco(produto.getPreco());
            existente.setCategoria(produto.getCategoria());

            return repository.save(existente);
        }

        // CREATE (novo produto)
        produto.setId(UUID.randomUUID().toString());
        return repository.save(produto);
    }
    @Transactional
    @Override
    public void excluir(String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

        repository.delete(produto);
    }
}