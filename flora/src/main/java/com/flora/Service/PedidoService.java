package com.flora.Service;

import com.flora.Model.PedidoModel;
import com.flora.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public ResponseEntity<String> save(PedidoModel pedidoModel){
        try {
            pedidoRepository.save(pedidoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Pedido salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar o pedido. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<PedidoModel>> getAll(){
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    public ResponseEntity<Object> getById(Long id){
        try {
            Optional<PedidoModel> pedido = pedidoRepository.findById(id);
            if (pedido.isEmpty()){
                return ResponseEntity.badRequest().body("Esse pedido ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(pedido.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar o pedido. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getByIdCliente(Long idCliente){
        try {
            List<PedidoModel> pedido = pedidoRepository.findByClienteId(idCliente);
            if (pedido.isEmpty()){
                return ResponseEntity.badRequest().body("Esse pedido ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar o pedido. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getByIdProduto(Long idProduto){
        try {
            List<PedidoModel> pedido = pedidoRepository.findByClienteId(idProduto);
            if (pedido.isEmpty()){
                return ResponseEntity.badRequest().body("Esse pedido ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar o pedido. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(Long id, PedidoModel pedidoModel){
        try {
            Optional<PedidoModel> pedido = pedidoRepository.findById(id);
            if (pedido.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
            }
            PedidoModel pedidoToUpdate = (PedidoModel) pedido.get();

            pedidoToUpdate.setProduto(pedidoModel.getProduto());
            pedidoToUpdate.setCliente(pedidoModel.getCliente());
            pedidoToUpdate.setDataPedido(pedidoModel.getDataPedido());
            pedidoToUpdate.setQntProduto(pedidoModel.getQntProduto());
            pedidoToUpdate.setFormaPgto(pedidoModel.getFormaPgto());
            pedidoToUpdate.setPrecoTotal(pedidoModel.getPrecoTotal());

            pedidoRepository.save(pedidoToUpdate);
            return ResponseEntity.ok("Pedido atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o pedido.");
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<PedidoModel> pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok("Pedido deletado com sucesso!");
    }
}
