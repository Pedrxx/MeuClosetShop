package meuclosetshop.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    Pessoa findByEmail(String email);

    
}
