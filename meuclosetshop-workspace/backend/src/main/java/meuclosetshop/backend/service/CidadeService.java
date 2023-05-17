package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Cidade;
import meuclosetshop.backend.entity.Estado;
import meuclosetshop.backend.repository.CidadeRepository;
import meuclosetshop.backend.repository.EstadoRepository;

@Service
public class CidadeService {
    

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> listarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;
    }

    public Cidade atualizar(Cidade cidade) {
        cidade.setDataAtualizacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;    }

    public void excluir(Long id) {
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }
}
