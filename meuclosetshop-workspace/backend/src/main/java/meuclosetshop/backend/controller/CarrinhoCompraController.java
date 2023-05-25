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

import meuclosetshop.backend.entity.CarrinhoCompra;
import meuclosetshop.backend.service.CarrinhoCompraService;

@RestController
@RequestMapping("/carrinhoCompra")
@CrossOrigin
public class CarrinhoCompraController {
    
    @Autowired
    CarrinhoCompraService carrinhoCompraService;

    @GetMapping("/")
    public List<CarrinhoCompra> listarTodos() {
        return carrinhoCompraService.listarTodos();
    }

    @PostMapping("/")
    public CarrinhoCompra inserir(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraService.inserir(carrinhoCompra);
    }

    @PutMapping("/")
    public CarrinhoCompra alterar(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraService.atualizar(carrinhoCompra);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        carrinhoCompraService.excluir(id);
    }
    
}
