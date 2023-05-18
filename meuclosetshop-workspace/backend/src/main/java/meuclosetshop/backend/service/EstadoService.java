package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Estado;
import meuclosetshop.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listarTodos() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> buscarPorId(Long id) {
        return estadoRepository.findById(id);
    }

    public Estado inserir(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado atualizar(Estado estado) {
        estado.setDataAtualizacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }
    
}
