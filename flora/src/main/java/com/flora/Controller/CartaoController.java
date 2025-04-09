package com.flora.Controller;

import com.flora.Model.CartaoModel;
import com.flora.Service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/saveCard")
    public ResponseEntity<String> saveCard(@RequestBody CartaoModel cartaoModel){
        return cartaoService.save(cartaoModel);
    }

    @GetMapping("/getCards")
    public ResponseEntity<List<CartaoModel>> getAllCards() {
        return cartaoService.getAll();
    }

    @GetMapping("/getCard/{id}")
    public ResponseEntity<Object> getCardById(@PathVariable Long id){
        return cartaoService.getById(id);
    }

    @GetMapping("/getOrderByClientId/{id}")
    public ResponseEntity<Object> getOrderByIdCliente(@PathVariable Long id){
        return cartaoService.getByIdCliente(id);
    }


    @PutMapping("/updateCard/{id}")
    public ResponseEntity<Object> updateCard(@PathVariable Long id, @RequestBody CartaoModel cartaoModel){
        return cartaoService.update(id, cartaoModel);
    }
    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable Long id){
        return cartaoService.delete(id);
    }
}

