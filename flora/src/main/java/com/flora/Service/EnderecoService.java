package com.flora.Service;

import com.flora.Model.EnderecoModel;
import com.flora.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public ResponseEntity<Object> getByIdCliente(Long idCliente){
        try {
            List<EnderecoModel> endereco = enderecoRepository.findByClienteId(idCliente);
            if (endereco.isEmpty()){
                return ResponseEntity.badRequest().body("Esse endereço ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(endereco);
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
            enderecoRepository.save(updateEndereco(enderecoModel, enderecoToUpdate));
            return ResponseEntity.ok("Endereço atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o endereço.");
        }
    }

    public ResponseEntity<String> partialUpdate(Long id, Map<Object, Object> updates) {
        try {
            Optional<EnderecoModel> enderecoOptional = enderecoRepository.findById(id);

            if (enderecoOptional.isPresent()) {
                EnderecoModel enderecoToUpdate = enderecoOptional.get();

                if (updates.containsKey("cep")) {
                    enderecoToUpdate.setCep(updates.get("cep").toString());
                }
                if (updates.containsKey("numero")) {
                    enderecoToUpdate.setNumero(updates.get("numero").toString());
                }
                if (updates.containsKey("logradouro")) {
                    enderecoToUpdate.setLogradouro(updates.get("logradouro").toString());
                }
                if (updates.containsKey("bairro")) {
                    enderecoToUpdate.setBairro(updates.get("bairro").toString());
                }
                if (updates.containsKey("cidade")) {
                    enderecoToUpdate.setCidade(updates.get("cidade").toString());
                }
                if (updates.containsKey("estado")) {
                    enderecoToUpdate.setEstado(updates.get("estado").toString());
                }
                if (updates.containsKey("pontoReferencia")) {
                    enderecoToUpdate.setPontoReferencia(updates.get("pontoReferencia").toString());
                }

                enderecoRepository.save(enderecoToUpdate);
                return ResponseEntity.ok("Endereço atualizado com sucesso!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
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

    public EnderecoModel updateEndereco(EnderecoModel enderecoModel, EnderecoModel enderecoToUpdate){
        enderecoToUpdate.setCliente(enderecoModel.getCliente());
        enderecoToUpdate.setCep(enderecoModel.getCep());
        enderecoToUpdate.setNumero(enderecoModel.getNumero());
        enderecoToUpdate.setLogradouro(enderecoModel.getLogradouro());
        enderecoToUpdate.setBairro(enderecoModel.getBairro());
        enderecoToUpdate.setCidade(enderecoModel.getCidade());
        enderecoToUpdate.setEstado(enderecoModel.getEstado());
        enderecoToUpdate.setPontoReferencia(enderecoModel.getPontoReferencia());

        return enderecoToUpdate;
    }
}
