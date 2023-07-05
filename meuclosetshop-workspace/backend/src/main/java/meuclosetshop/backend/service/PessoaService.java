package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Pessoa;
import meuclosetshop.backend.repository.PessoaRepository;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodos() {
        // System.out.println(pessoaRepository.findAll());
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa) {
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        pessoa.setDataAtualizacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

    public List<Pessoa> buscarPorIdCidade(Long idCidade) {
        return pessoaRepository.findByIdCidade(idCidade);
    }

    public List<Pessoa> buscarPorNomeCidade(String nomeCidade) {
        return pessoaRepository.findByNomeCidade(nomeCidade);
    }

    public List<Pessoa> buscarPorNomeEstado(String nomeEstado) {
        return pessoaRepository.findByNomeEstado(nomeEstado);
    }
    
}
