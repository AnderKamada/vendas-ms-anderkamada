package br.com.fiap.vendasms.service;

import br.com.fiap.vendasms.entities.Produto;
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

        if (produto.getId() == null) {
            produto.setId(UUID.randomUUID().toString());
        }

        // CREATE
        produto.setId(String.valueOf(UUID.randomUUID()));
        return repository.save(produto);
    }
    @Transactional
    @Override
    public void excluir(String id) {
        repository.deleteById(id);
    }
}