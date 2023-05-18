package meuclosetshop.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meuclosetshop.backend.entity.PermissaoPessoa;
import meuclosetshop.backend.service.PermissaoPessoaService;

@RequestMapping("/permissaoPessoa")
@RestController
@CrossOrigin
public class PermissaoPessoaController {
  
  
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @GetMapping("/")
    public List<PermissaoPessoa> listarTodos() {
        return permissaoPessoaService.listarTodos();
    }

    @PostMapping("/")
    public PermissaoPessoa inserir(@RequestBody PermissaoPessoa permissaoPessoa){
        return permissaoPessoaService.inserir(permissaoPessoa);
    }

    @PutMapping("/")
    public PermissaoPessoa alterar(@RequestBody PermissaoPessoa permissaoPessoa){
        return permissaoPessoaService.atualizar(permissaoPessoa);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        permissaoPessoaService.excluir(id);
    }
}
