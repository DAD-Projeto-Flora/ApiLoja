package com.flora.Service;

import com.flora.Model.ClienteModel;
import com.flora.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
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

    public ResponseEntity<String> update(Long id, ClienteModel clienteModel){
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

    public ResponseEntity<String> partialUpdate(Long id, Map<Object, Object> updates) {
        try {
            Optional<ClienteModel> clienteOptional = clienteRepository.findById(id);

            if (clienteOptional.isPresent()) {
                ClienteModel clienteToUpdate = clienteOptional.get();

                if (updates.containsKey("nomeCompleto")) {
                    clienteToUpdate.setNomeCompleto(updates.get("nomeCompleto").toString());
                }
                if (updates.containsKey("nomeUsuario")) {
                    clienteToUpdate.setNomeUsuario(updates.get("nomeUsuario").toString());
                }
                if (updates.containsKey("telefone")) {
                    clienteToUpdate.setTelefone(updates.get("telefone").toString());
                }
                if (updates.containsKey("senha")) {
                    clienteToUpdate.setSenha(updates.get("senha").toString());
                }
                if (updates.containsKey("fotoPerfil")) {
                    clienteToUpdate.setFotoPerfil(updates.get("fotoPerfil").toString());
                }
                if (updates.containsKey("email")) {
                    clienteToUpdate.setEmail(updates.get("email").toString());
                }

                clienteRepository.save(clienteToUpdate);

                return ResponseEntity.ok("Cliente atualizado com sucesso!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o cliente.");
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        try {
            Optional<ClienteModel> cliente = clienteRepository.findById(id);
            if (cliente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
            }
            clienteRepository.deleteById(id);
            return ResponseEntity.ok("Cliente deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível deletar o cliente.");
        }
    }
}
