package com.flora.Service;

import com.flora.Model.CartaoModel;
import com.flora.Repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public ResponseEntity<String> save(CartaoModel cartaoModel){
        try {
            cartaoRepository.save(cartaoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cartão salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar o cartão. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<CartaoModel>> getAll(){
        return ResponseEntity.ok(cartaoRepository.findAll());
    }

    public ResponseEntity<Object> getById(Long id){
        try {
            Optional<CartaoModel> cartao = cartaoRepository.findById(id);
            if (cartao.isEmpty()){
                return ResponseEntity.badRequest().body("Esse cartão ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(cartao.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscar o cartão. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getByIdCliente(Long cartaoId){
        try {
            List<CartaoModel> cartao = cartaoRepository.findByClienteId(cartaoId);
            if (cartao.isEmpty()){
                return ResponseEntity.badRequest().body("Esse cartão ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(cartao);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscar o cartão. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(Long id, CartaoModel cartaoModel){
        try {
            Optional<CartaoModel> cartao = cartaoRepository.findById(id);
            if (cartao.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
            }
            CartaoModel cartaoToUpdate = (CartaoModel) cartao.get();
            cartaoToUpdate.setCliente(cartaoModel.getCliente());
            cartaoToUpdate.setNumero(cartaoModel.getNumero());
            cartaoToUpdate.setNomeCartao(cartaoToUpdate.getNomeCartao());
            cartaoToUpdate.setCvv(cartaoToUpdate.getCvv());
            cartaoToUpdate.setApelidoCartao(cartaoModel.getApelidoCartao());
            cartaoToUpdate.setValidade(cartaoModel.getValidade());


            cartaoRepository.save(cartaoToUpdate);
            return ResponseEntity.ok("Cartão atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o cartão.");
        }
    }

    public ResponseEntity<String> partialUpdate(Long id, Map<Object, Object> updates) {
        try {
            Optional<CartaoModel> cartaoOptional = cartaoRepository.findById(id);

            if (cartaoOptional.isPresent()) {
                CartaoModel cartaoToUpdate = cartaoOptional.get();
                if (updates.containsKey("apelidoCartao")) {
                    cartaoToUpdate.setApelidoCartao(updates.get("apelidoCartao").toString());
                }
                cartaoRepository.save(cartaoToUpdate);
                return ResponseEntity.ok("Cartão atualizado com sucesso!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o cartão.");
        }
    }


    public ResponseEntity<Object> delete(Long id) {
        try {
            Optional<CartaoModel> cartao = cartaoRepository.findById(id);
            if (cartao.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
            }
            cartaoRepository.deleteById(id);
            return ResponseEntity.ok("Cartão deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível deletar o cartão.");
        }
    }
}
