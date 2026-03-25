package br.com.fiap.vendasms.dto;

import br.com.fiap.vendasms.entities.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProdutoDto(
        String id,
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
        Produto p = new Produto();

        p.setId(this.id);
        p.setNome(this.nome);
        p.setDescricao(this.descricao);
        p.setPreco(this.preco);
        p.setCategoria(this.categoria);

        return p;
    }

    public static ProdutoDto empty(String id) {
        return new ProdutoDto(
                id,
                "",
                "",
                BigDecimal.ZERO,
                ""
        );
    }
}