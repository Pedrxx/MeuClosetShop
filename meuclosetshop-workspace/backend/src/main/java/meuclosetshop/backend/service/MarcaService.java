package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Marca;
import meuclosetshop.backend.repository.MarcaRepository;


@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodos() {
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca marcaNovo = marcaRepository.saveAndFlush(marca);
        return marcaNovo;
    }

    public Marca atualizar(Marca marca) {
        marca.setDataAtualizacao(new Date());
        Marca marcaNovo = marcaRepository.saveAndFlush(marca);
        return marcaNovo;
    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
