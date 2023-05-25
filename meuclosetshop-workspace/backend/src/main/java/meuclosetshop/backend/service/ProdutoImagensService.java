package meuclosetshop.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import meuclosetshop.backend.entity.Produto;
import meuclosetshop.backend.entity.ProdutoImagens;
import meuclosetshop.backend.repository.ProdutoImagensRepository;
import meuclosetshop.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> listarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long id, MultipartFile file) {
        Produto produto = produtoRepository.findById(id).get();
        ProdutoImagens objeto = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto = produtoImagensRepository.saveAndFlush(objeto);
        return objeto;
    }

    public ProdutoImagens atualizar(ProdutoImagens produtoImagens) {
        produtoImagens.setDataAtualizacao(new Date());
        ProdutoImagens produtoImagensNovo = produtoImagensRepository.saveAndFlush(produtoImagens);
        return produtoImagensNovo;    }

    public void excluir(Long id) {
        ProdutoImagens produtoImagens = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagens);
    }

    
}
