package br.com.fiap.vendasms.service;

import br.com.fiap.vendasms.entities.Produto;
import br.com.fiap.vendasms.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {

        if (produto.getId() != null) {
            // UPDATE
            Produto existente = repository.findById(produto.getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            existente.setNome(produto.getNome());
            existente.setDescricao(produto.getDescricao());
            existente.setPreco(produto.getPreco());
            existente.setCategoria(produto.getCategoria());

            return repository.save(existente);
        }

        // CREATE
        produto.setId(UUID.randomUUID());
        return repository.save(produto);
    }
    @Override
    public void excluir(UUID id) {
        repository.deleteById(id);
    }
}