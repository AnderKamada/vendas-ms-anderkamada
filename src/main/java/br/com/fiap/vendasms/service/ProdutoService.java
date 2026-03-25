package br.com.fiap.vendasms.service;

import br.com.fiap.vendasms.entities.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    Produto buscarPorId(UUID id);

    List<Produto> listarTodos();

    Produto salvar(Produto produto);

    void excluir(UUID id);

}