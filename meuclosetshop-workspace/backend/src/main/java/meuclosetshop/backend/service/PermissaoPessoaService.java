package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.PermissaoPessoa;
import meuclosetshop.backend.repository.PermissaoPessoaRepository;

@Service
public class PermissaoPessoaService {
    
        
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    public List<PermissaoPessoa> listarTodos() {
        return permissaoPessoaRepository.findAll();
    }

    public Optional<PermissaoPessoa> buscarPorId(Long id) {
        return permissaoPessoaRepository.findById(id);
    }

    public PermissaoPessoa inserir(PermissaoPessoa permissaoPessoa) {
        permissaoPessoa.setDataCriacao(new Date());
        PermissaoPessoa permissaoPessoaNovo = permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        return permissaoPessoaNovo;
    }

    public PermissaoPessoa atualizar(PermissaoPessoa permissaoPessoa) {
        permissaoPessoa.setDataAtualizacao(new Date());
        PermissaoPessoa permissaoPessoaNovo = permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        return permissaoPessoaNovo;
    }

    public void excluir(Long id) {
        PermissaoPessoa permissaoPessoa = permissaoPessoaRepository.findById(id).get();
        permissaoPessoaRepository.delete(permissaoPessoa);
    }


}
