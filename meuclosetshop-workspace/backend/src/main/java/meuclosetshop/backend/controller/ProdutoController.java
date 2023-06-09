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

import meuclosetshop.backend.entity.Produto;
import meuclosetshop.backend.service.ProdutoService;

@RequestMapping("/produto")
@RestController
@CrossOrigin
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    
    @GetMapping("/")
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto){
        return produtoService.atualizar(produto);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        produtoService.excluir(id);
    }
}
