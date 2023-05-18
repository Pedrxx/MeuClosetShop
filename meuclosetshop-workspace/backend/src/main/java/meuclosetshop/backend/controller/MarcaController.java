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

import meuclosetshop.backend.entity.Marca;
import meuclosetshop.backend.service.MarcaService;

@RestController
@RequestMapping("/marca")
@CrossOrigin
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> listarTodos() {
        return marcaService.listarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca){
        return marcaService.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca){
        return marcaService.atualizar(marca);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        marcaService.excluir(id);
    }
}
