package meuclosetshop.backend.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "nome")
    private String nome;
    
    @NotNull
    @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "Formato de CPF inválido")
    @Column(name = "cpf")
    private String cpf;
    
    @NotNull
    @Email
    @Column(name = "email")
    private String email;
    
    @JsonIgnore
    @Size(min = 8, max = 20, message = "O campo deve ter entre 8 e 20 caracteres")
    @Column(name = "senha")
    private String senha; 

    @JsonIgnore
    @Column(name = "cod_rec_senha")
    private String codRecuperacaoSenha;

    @JsonIgnore
    @Column(name = "dataEnvioCod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCod;

    @Column(name = "endereco")
    private String endereco;

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato de CEP inválido")
    @Column(name = "cep")
    private String cep;

    @JsonIgnore
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @JsonIgnore
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    // @JsonIgnore
    @ManyToOne
    private Cidade cidade;

    // @JsonIgnore
    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoa;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for(PermissaoPessoa p:pp) {
            p.setPessoa(this);
        }
        this.permissaoPessoa = pp;

    }

}
