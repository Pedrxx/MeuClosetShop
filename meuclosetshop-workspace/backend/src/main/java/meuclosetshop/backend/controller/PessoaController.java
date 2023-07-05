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

import jakarta.websocket.server.PathParam;
import meuclosetshop.backend.entity.Pessoa;
import meuclosetshop.backend.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> listarTodos() {
        // System.out.print(pessoaService.listarTodos());
        return pessoaService.listarTodos();
    }

    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa pessoa){
        return pessoaService.inserir(pessoa);
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa pessoa){
        return pessoaService.atualizar(pessoa);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        pessoaService.excluir(id);
    }

    @GetMapping("/cidade/{idCidade}")
    public List<Pessoa> buscarPessoasPorCidade(@PathVariable Long idCidade) {
        return pessoaService.buscarPorIdCidade(idCidade);
    }

    @GetMapping("/cidade")
    public List<Pessoa> buscarPessoasPorCidade(@RequestParam("nomeCidade") String nomeCidade) {
        System.out.println(nomeCidade);
        return pessoaService.buscarPorNomeCidade(nomeCidade);
    }

    @GetMapping("/estado")
    public List<Pessoa> buscarPessoasPorEstado(@RequestParam("nomeEstado") String nomeEstado) {
        return pessoaService.buscarPorNomeEstado(nomeEstado);
    }
    
}
