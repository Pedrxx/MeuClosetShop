package meuclosetshop.backend.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

import jakarta.transaction.Transactional;
import meuclosetshop.backend.entity.Cidade;
import meuclosetshop.backend.entity.Estado;
import meuclosetshop.backend.repository.CidadeRepository;
import meuclosetshop.backend.repository.EstadoRepository;

@Service
public class CidadeService {
    

    @Autowired
    private CidadeRepository cidadeRepository;
    private EstadoRepository estadoRepository;

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

    @Transactional
    public void gravarDadosCSV(String caminhoArquivoCSV) {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivoCSV))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                Cidade cidade = new Cidade();
                Estado estado = estadoRepository.findById(Long.parseLong(linha[3])).get();
                
                cidade.setNome(linha[1]);
                cidade.setStatus(linha[2]);
                cidade.setEstado(estado);
                cidade.setSelecionada(linha[4]);
                cidade.setDataCriacao(new Date());
                cidadeRepository.save(cidade);
            }   
        } catch (IOException e) {
            // Tratar exceção de leitura do arquivo CSV
        }
    }
}
