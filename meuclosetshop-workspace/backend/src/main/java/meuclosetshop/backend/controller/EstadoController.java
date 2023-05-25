package meuclosetshop.backend.controller;

import java.util.List;
import java.util.Optional;

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


import meuclosetshop.backend.entity.Estado;
import meuclosetshop.backend.service.EstadoService;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @GetMapping("/")
    public List<Estado> listarTodos() {
        return estadoService.listarTodos();
    }

    @GetMapping("/buscaId")
    public Optional<Estado> buscaPorId(Long id) {
        return estadoService.buscarPorId(id);
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody Estado estado) {
        return estadoService.inserir(estado);
    }

    @PostMapping("/importar-csv")
    public String importarCSV(@RequestParam("caminhoArquivo") String caminhoArquivo) {
        estadoService.gravarDadosCSV(caminhoArquivo);
        return "Dados do CSV importados com sucesso!";
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado) {
        return estadoService.atualizar(estado);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        estadoService.excluir(id);
    }
}
