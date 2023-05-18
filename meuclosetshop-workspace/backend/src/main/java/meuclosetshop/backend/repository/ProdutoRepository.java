package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
