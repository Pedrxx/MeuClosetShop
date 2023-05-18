package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Categoria;
import meuclosetshop.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        Categoria categoriaNovo = categoriaRepository.saveAndFlush(categoria);
        return categoriaNovo;
    }

    public Categoria atualizar(Categoria categoria) {
        categoria.setDataAtualizacao(new Date());
        Categoria categoriaNovo = categoriaRepository.saveAndFlush(categoria);
        return categoriaNovo;    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }

    
}
