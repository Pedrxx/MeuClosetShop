package meuclosetshop.backend.service;

import java.io.FileReader;
import java.io.IOException;
// import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.opencsv.CSVParser;
// import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
// import com.opencsv.CSVReaderBuilder;

import jakarta.transaction.Transactional;
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

    @Transactional
    public void gravarDadosCSV(String caminhoArquivo) {
        // CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        // try (CSVReader reader = new CSVReaderBuilder(caminhoArquivo)
        // .withCSVParser(parser)
        // .build();) {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
            String[] linha;
            reader.readNext();
            while ((linha = reader.readNext()) != null) {
                Estado estado = new Estado();
                estado.setNome(linha[1]);
                estado.setSigla(linha[2]);
                estado.setStatus(linha[3]);
                estado.setDataCriacao(new Date());
                estadoRepository.save(estado);
            }
        } catch (IOException e) {
            // Tratar exceção de leitura do arquivo CSV
        }
    }

}

