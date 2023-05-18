package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Permissao;
import meuclosetshop.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> listarTodos() {
        return permissaoRepository.findAll();
    }

    public Optional<Permissao> buscarPorId(Long id) {
        return permissaoRepository.findById(id);
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;
    }

    public Permissao atualizar(Permissao permissao) {
        permissao.setDataAtualizacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;
    }

    public void excluir(Long id) {
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }

}
