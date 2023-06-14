package meuclosetshop.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.dto.PessoaClienteRequestDTO;
import meuclosetshop.backend.entity.Pessoa;
import meuclosetshop.backend.repository.PessoaClienteRepository;


@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPermissaoPessoaCliente(pessoaNovo);
        emailService.enviaEmail(
            pessoaNovo.getEmail(), 
            "Cadastro realizado com sucesso", 
            "Olá "+pessoaNovo.getNome() +" Seu cadastro no Meu Closet Shop foi realizado com sucesso! Boas compras!");
        return pessoaNovo;
    }

}
