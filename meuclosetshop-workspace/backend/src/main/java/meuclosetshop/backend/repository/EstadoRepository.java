package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
}
