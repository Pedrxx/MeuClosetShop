package meuclosetshop.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}