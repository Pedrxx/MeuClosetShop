package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
}
