package com.flora.Service;

import com.flora.Model.ClienteModel;
import com.flora.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<String> save(ClienteModel clienteModel){
        try {
            clienteRepository.save(clienteModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar o cliente. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<ClienteModel>> getAll(){
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    public ResponseEntity<Object> getById(Long id){
        try {
            Optional<ClienteModel> cliente = clienteRepository.findById(id);
            if (cliente.isEmpty()){
                return ResponseEntity.badRequest().body("Esse cliente ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(cliente.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar o cliente. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(Long id, ClienteModel clienteModel){
        try {
            Optional<ClienteModel> cliente = clienteRepository.findById(id);
            if (cliente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
            }
            ClienteModel clienteToUpdate = (ClienteModel) cliente.get();

            clienteToUpdate.setNomeCompleto(clienteModel.getNomeCompleto());
            clienteToUpdate.setEmail(clienteModel.getEmail());
            clienteToUpdate.setFotoPerfil(clienteModel.getFotoPerfil());
            clienteToUpdate.setNomeUsuario(clienteModel.getNomeUsuario());
            clienteToUpdate.setTelefone(clienteModel.getTelefone());
            clienteToUpdate.setSenha(clienteModel.getSenha());

            clienteRepository.save(clienteToUpdate);
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o cliente.");
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso!");
    }
}
