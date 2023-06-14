package meuclosetshop.backend.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Pessoa;
import meuclosetshop.backend.repository.PessoaRepository;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitaCodigo(String email) {

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodRecuperacaoSenha(getCodRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCod(new Date());
        pessoaRepository.saveAndFlush(null);
        emailService.enviaEmail(
            pessoa.getEmail(), 
            "Código de recuperação de senha", 
            "Olá "+ pessoa.getNome() +"! O seu código de recuperaçaõ de senha é: "+ pessoa.getCodRecuperacaoSenha());
        return "Código enviado!";
    }

    private String getCodRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmSSmm");
        return format.format(new Date()) + id; 

    }
}
