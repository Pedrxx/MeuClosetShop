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
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descCurta")
    private String descCurta;

    @Column(name = "descDetalhada")
    private String descDetalhada;

    @Column(name = "valorCusto")
    private double valorCusto;

    @Column(name = "valorVenda")
    private double valorVenda;

    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Categoria categoria;
}
