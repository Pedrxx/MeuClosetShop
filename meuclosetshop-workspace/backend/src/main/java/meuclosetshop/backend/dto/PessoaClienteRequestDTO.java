package meuclosetshop.backend.dto;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import meuclosetshop.backend.entity.Cidade;
import meuclosetshop.backend.entity.Pessoa;

@Data
public class PessoaClienteRequestDTO {
    
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;

    public Pessoa converter(PessoaClienteRequestDTO pessoaClienteRequestDTO) {

        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa);
        return pessoa;
        
    }
    
}
