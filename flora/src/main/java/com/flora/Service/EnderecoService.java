package com.flora.Service;

import com.flora.Model.EnderecoModel;
import com.flora.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public ResponseEntity<String> save(EnderecoModel enderecoModel){
        try {
            enderecoRepository.save(enderecoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Endereço salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar o endereço. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<EnderecoModel>> getAll(){
        return ResponseEntity.ok(enderecoRepository.findAll());
    }

    public ResponseEntity<Object> getById(Long id){
        try {
            Optional<EnderecoModel> endereco = enderecoRepository.findById(id);
            if (endereco.isEmpty()){
                return ResponseEntity.badRequest().body("Esse endereço ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(endereco.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscar o endereço. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(Long id, EnderecoModel enderecoModel){
        try {
            Optional<EnderecoModel> endereco = enderecoRepository.findById(id);
            if (endereco.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
            }
            EnderecoModel enderecoToUpdate = (EnderecoModel) endereco.get();
            enderecoToUpdate.setIdCliente(enderecoModel.getIdCliente());
            enderecoToUpdate.setCep(enderecoModel.getCep());
            enderecoToUpdate.setNumero(enderecoModel.getNumero());
            enderecoToUpdate.setLogradouro(enderecoModel.getLogradouro());
            enderecoToUpdate.setBairro(enderecoModel.getBairro());
            enderecoToUpdate.setCidade(enderecoModel.getCidade());
            enderecoToUpdate.setEstado(enderecoModel.getEstado());
            enderecoToUpdate.setPontoReferencia(enderecoModel.getPontoReferencia());

            
            enderecoRepository.save(enderecoToUpdate);
            return ResponseEntity.ok("Endereço atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o endereço.");
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<EnderecoModel> endereco = enderecoRepository.findById(id);
        if (endereco.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
        }
        enderecoRepository.deleteById(id);
        return ResponseEntity.ok("Endereço deletado com sucesso!");
    }
}
