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

import meuclosetshop.backend.entity.Permissao;
import meuclosetshop.backend.service.PermissaoService;


@RequestMapping("/permissao")
@RestController
@CrossOrigin
public class PermissaoController {
    
        
    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> listarTodos() {
        return permissaoService.listarTodos();
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao permissao){
        return permissaoService.inserir(permissao);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao permissao){
        return permissaoService.atualizar(permissao);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        permissaoService.excluir(id);
    }
}
