package meuclosetshop.backend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Size(min = 2, max = 2, message = "O campo deve ter apenas 2 caracteres")
    @Column(name = "sigla", unique = true)
    private String sigla;
    
    @NotNull
    @Size(min = 1, max = 1, message = "O campo deve ter apenas 1 caracter (A/I)")
    @Pattern(regexp = "^[IN]$", message = "O campo deve conter apenas 'I', para inativo, ou 'A', para ativo")
    @Column(name = "status")
    private String status;

    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;


    
}
