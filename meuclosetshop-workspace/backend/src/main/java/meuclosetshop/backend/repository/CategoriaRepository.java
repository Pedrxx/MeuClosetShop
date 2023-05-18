package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
