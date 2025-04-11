package com.flora.Controller;

import com.flora.Model.ClienteModel;
import com.flora.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/saveClient")
    public ResponseEntity<String> saveClient(@RequestBody ClienteModel clienteModel){
        return clienteService.save(clienteModel);
    }

    @GetMapping("/getClients")
    public ResponseEntity<List<ClienteModel>> getAllClients() {
        return clienteService.getAll();
    }

    @GetMapping("/getClient/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable Long id){
        return clienteService.getById(id);
    }


    @PutMapping("/updateClient/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        return clienteService.update(id, clienteModel);
    }

    @PatchMapping("/partialUpdateClient/{id}")
    public ResponseEntity<String> partialUpdateClient(@PathVariable Long id, @RequestBody Map<Object, Object> updates){
        return clienteService.partialUpdate(id, updates);
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        return clienteService.delete(id);
    }
}

