package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.ProdutoImagens;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
    
}
