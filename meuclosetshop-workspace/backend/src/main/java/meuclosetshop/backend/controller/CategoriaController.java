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

import meuclosetshop.backend.entity.Categoria;
import meuclosetshop.backend.service.CategoriaService;

@RequestMapping("/categoria")
@RestController
@CrossOrigin
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaService.inserir(categoria);
    }

    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria categoria){
        return categoriaService.atualizar(categoria);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        categoriaService.excluir(id);
    }
    
}
