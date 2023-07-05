package meuclosetshop.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import meuclosetshop.backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    Pessoa findByEmail(String email);


    @Query("from Pessoa p where cidade.id = ?1")
    List<Pessoa> findByIdCidade(Long idCidade);

    @Query("from Pessoa p where cidade.nome like %?1%")
        List<Pessoa> findByNomeCidade(String nomeCidade);

    @Query("from Pessoa p where cidade.estado.nome like %?1%")
        List<Pessoa> findByNomeEstado(String nomeEstado);

}
