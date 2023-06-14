package meuclosetshop.backend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "carrinhoCompraProduto")
public class CarrinhoCompraProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d+)?$", message = "O campo deve conter um valor separado por ponto, caso necessário.")
    @Column(name = "valor")
    private double dataCompra;

    @Pattern(regexp = "[0-9]+$", message = "O campo deve conter um valor")
    @Column(name = "quantidade")
    private double quantidade;

    @NotNull
    @Column(name = "observacao")
    private String observacao;

    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
