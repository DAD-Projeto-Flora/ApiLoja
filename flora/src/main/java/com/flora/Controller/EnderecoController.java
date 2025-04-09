package com.flora.Controller;

import com.flora.Model.EnderecoModel;
import com.flora.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/saveAddress")
    public ResponseEntity<String> saveAddress(@RequestBody EnderecoModel enderecoModel){
        return enderecoService.save(enderecoModel);
    }

    @GetMapping("/getAddresses")
    public ResponseEntity<List<EnderecoModel>> getAllAddresses() {
        return enderecoService.getAll();
    }

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<Object> getAddressById(@PathVariable Long id){
        return enderecoService.getById(id);
    }

    @GetMapping("/getAdressByClientId/{id}")
    public ResponseEntity<Object> getOrderByIdCliente(@PathVariable Long id){
        return enderecoService.getByIdCliente(id);
    }

    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<Object> updateAddress(@PathVariable Long id, @RequestBody EnderecoModel enderecoModel){
        return enderecoService.update(id, enderecoModel);
    }
    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable Long id){
        return enderecoService.delete(id);
    }
}

