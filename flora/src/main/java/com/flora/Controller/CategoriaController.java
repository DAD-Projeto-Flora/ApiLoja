package com.flora.Controller;

import com.flora.Model.CategoriaModel;
import com.flora.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/saveCategory")
    public ResponseEntity<String> saveCategory(@RequestBody CategoriaModel categoriaModel){
        return categoriaService.save(categoriaModel);
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List<CategoriaModel>> getAllCategories() {
        return categoriaService.getAll();
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Long id){
        return categoriaService.getById(id);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel){
        return categoriaService.update(id, categoriaModel);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id){
        return categoriaService.delete(id);
    }
}

