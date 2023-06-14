package meuclosetshop.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import meuclosetshop.backend.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("/pessoaGerenciamento")
@CrossOrigin
public class PessoaGerenciamentoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/")
    public String recuperarCodigo(@RequestParam("email") String email){

        return pessoaGerenciamentoService.solicitaCodigo(email);
    }
    
}
