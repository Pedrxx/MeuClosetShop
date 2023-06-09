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

import meuclosetshop.backend.entity.Cidade;
import meuclosetshop.backend.service.CidadeService;


@RestController
@RequestMapping("/cidade")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> listarTodos() {
        return cidadeService.listarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);
    }

    @PostMapping("/importar-csv")
    public String importarCSV(@RequestParam("caminhoArquivo") String caminhoArquivo) {
        cidadeService.gravarDadosCSV(caminhoArquivo);
        return "Dados do CSV importados com sucesso!";
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade cidade){
        return cidadeService.atualizar(cidade);
    }

    @DeleteMapping("/")
    public void exlcuir(@PathVariable("id") Long id) {
        cidadeService.excluir(id);
    }
    
}
