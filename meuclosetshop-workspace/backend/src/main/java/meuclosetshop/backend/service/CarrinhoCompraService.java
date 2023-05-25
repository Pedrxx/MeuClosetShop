package meuclosetshop.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entity.CarrinhoCompra;
import meuclosetshop.backend.repository.CarrinhoCompraRepository;

@Service
public class CarrinhoCompraService {
    
    @Autowired
    CarrinhoCompraRepository carrinhoCompraRepository;

    
    public List<CarrinhoCompra> listarTodos() {
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra inserir(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.setDataCriacao(new Date());
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNovo;
    }

    public CarrinhoCompra atualizar(CarrinhoCompra carrinhoCompra) {
        carrinhoCompra.setDataAtualizacao(new Date());
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNovo;    }

    public void excluir(Long id) {
        CarrinhoCompra carrinhoCompra = carrinhoCompraRepository.findById(id).get();
        carrinhoCompraRepository.delete(carrinhoCompra);
    }  

}
