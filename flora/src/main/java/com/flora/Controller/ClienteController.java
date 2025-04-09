package com.flora.Controller;

import com.flora.Model.ClienteModel;
import com.flora.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
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
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        return clienteService.update(id, clienteModel);
    }
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        return clienteService.delete(id);
    }
}

