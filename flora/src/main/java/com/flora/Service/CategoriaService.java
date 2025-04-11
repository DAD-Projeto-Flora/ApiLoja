package com.flora.Service;

import com.flora.Model.CategoriaModel;
import com.flora.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ResponseEntity<String> save(CategoriaModel categoriaModel){
        try {
            categoriaRepository.save(categoriaModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Categoria salva com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar a categoria. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<CategoriaModel>> getAll(){
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    public ResponseEntity<Object> getById(Long id){
        try {
            Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
            if (categoria.isEmpty()){
                return ResponseEntity.badRequest().body("Essa categoria ainda não foi cadastrada.");
            }
            return ResponseEntity.ok(categoria.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar a categoria. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(Long id, CategoriaModel categoriaModel){
        try {
            Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
            if (categoria.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
            }
            CategoriaModel categoriaToUpdate = (CategoriaModel) categoria.get();

            categoriaToUpdate.setNome(categoriaModel.getNome());

            categoriaRepository.save(categoriaToUpdate);
            return ResponseEntity.ok("Categoria atualizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar a categoria.");
        }
    }

    public ResponseEntity<String> partialUpdate(Long id, Map<Object, Object> updates) {
        try {
            Optional<CategoriaModel> categoriaOptional = categoriaRepository.findById(id);

            if (categoriaOptional.isPresent()) {
                CategoriaModel categoriaToUpdate = categoriaOptional.get();
                if (updates.containsKey("nome")) {
                    categoriaToUpdate.setNome(updates.get("nome").toString());
                }
                categoriaRepository.save(categoriaToUpdate);
                return ResponseEntity.ok("Categoria atualizado com sucesso!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar a categoria.");
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        try {
            Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
            if (categoria.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
            }
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok("Categoria deletada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível deletar a categoria.");
        }
    }
}
