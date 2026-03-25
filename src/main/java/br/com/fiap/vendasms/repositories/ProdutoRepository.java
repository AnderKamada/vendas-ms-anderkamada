package br.com.fiap.vendasms.repositories;

import br.com.fiap.vendasms.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}