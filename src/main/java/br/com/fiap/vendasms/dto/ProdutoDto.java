package br.com.fiap.vendasms.dto;

import br.com.fiap.vendasms.entities.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProdutoDto(
        UUID id,
        String nome,
        String descricao,
        BigDecimal preco,
        String categoria
) {

    public static ProdutoDto from(Produto produto) {
        return new ProdutoDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getCategoria()
        );
    }

    public static List<ProdutoDto> from(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoDto::from)
                .toList();
    }

    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setPreco(this.preco);
        produto.setCategoria(this.categoria);
        return produto;
    }

    public static ProdutoDto empty(UUID id) {
        return new ProdutoDto(
                id,
                "",
                "",
                BigDecimal.ZERO,
                ""
        );
    }
}