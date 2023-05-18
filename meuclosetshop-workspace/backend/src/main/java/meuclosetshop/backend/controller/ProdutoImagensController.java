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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import meuclosetshop.backend.entity.ProdutoImagens;
import meuclosetshop.backend.service.ProdutoImagensService;

@RequestMapping("/produtosImagens")
@RestController
@CrossOrigin
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> listarTodos() {
        return produtoImagensService.listarTodos();
    }

    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam Long id, @RequestParam MultipartFile file){
        return produtoImagensService.inserir(id,file);
    }

    @PutMapping("/")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produtoImagens){
        return produtoImagensService.atualizar(produtoImagens);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        produtoImagensService.excluir(id);
    }
    
}
