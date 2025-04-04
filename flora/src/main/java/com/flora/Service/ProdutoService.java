package com.flora.Service;

import com.flora.Model.ProdutoModel;
import com.flora.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<String> save(ProdutoModel produtoModel){
        try {
            produtoRepository.save(produtoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Produto salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar o produto. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<ProdutoModel>> getAll(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    public ResponseEntity<Object> getById(Long id){
        try {
            Optional<ProdutoModel> produto = produtoRepository.findById(id);
            if (produto.isEmpty()){
                return ResponseEntity.badRequest().body("Esse produto ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(produto.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar o produto. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getByIdCategoria(int idCategoria){
        try {
            Optional<ProdutoModel> produto = produtoRepository.findBy(idCategoria);
            if (produto.isEmpty()){
                return ResponseEntity.badRequest().body("Esse produto ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(produto.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscaar o produto. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(Long id, ProdutoModel produtoModel){
        try {
            Optional<ProdutoModel> produto = produtoRepository.findById(id);
            if (produto.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }
            ProdutoModel produtoToUpdate = (ProdutoModel) produto.get();

            produtoToUpdate.setNome(produtoModel.getNome());
            produtoToUpdate.setIdCategoria(produtoModel.getIdCategoria());
            produtoToUpdate.setNotaAvaliacao(produtoModel.getNotaAvaliacao());
            produtoToUpdate.setPrecoUnid(produtoModel.getPrecoUnid());

            produtoRepository.save(produtoToUpdate);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o produto.");
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }
}
