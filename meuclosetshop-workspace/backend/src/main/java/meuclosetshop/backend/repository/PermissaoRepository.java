package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
}
