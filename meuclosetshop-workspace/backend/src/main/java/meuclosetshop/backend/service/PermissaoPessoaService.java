package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.Permissao;
import meuclosetshop.backend.entity.PermissaoPessoa;
import meuclosetshop.backend.entity.Pessoa;
import meuclosetshop.backend.repository.PermissaoPessoaRepository;
import meuclosetshop.backend.repository.PermissaoRepository;

@Service
public class PermissaoPessoaService {
    
        
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPermissaoPessoaCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if(listaPermissao.size()> 0 ) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
        }
    }


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
