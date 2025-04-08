package com.flora.Controller;

import com.flora.Model.ProdutoModel;
import com.flora.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestBody ProdutoModel produtoModel){
        return produtoService.save(produtoModel);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProdutoModel>> getAllProducts() {
        return produtoService.getAll();
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){
        return produtoService.getById(id);
    }

    @GetMapping("/getProductByCategory/{categoryId}")
    public ResponseEntity<Object> getProductByCategory(@PathVariable int categoryId){
        return produtoService.getByIdCategoria(categoryId);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        return produtoService.update(id, produtoModel);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        return produtoService.delete(id);
    }
}

