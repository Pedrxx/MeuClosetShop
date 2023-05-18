package meuclosetshop.backend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha; 

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @ManyToOne
    private Cidade cidade;
}
