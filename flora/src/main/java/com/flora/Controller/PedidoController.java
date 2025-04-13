package com.flora.Controller;

import com.flora.Model.PedidoModel;
import com.flora.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://site-loja-flora.vercel.app")
@RestController
@RequestMapping("/order")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/saveOrder")
    public ResponseEntity<String> saveOrder(@RequestBody PedidoModel pedidoModel){
        return pedidoService.save(pedidoModel);
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<PedidoModel>> getAllOrders() {
        return pedidoService.getAll();
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long id){
        return pedidoService.getById(id);
    }

    @GetMapping("/getOrderByClientId/{id}")
    public ResponseEntity<Object> getOrderByIdCliente(@PathVariable Long id){
        return pedidoService.getByIdCliente(id);
    }

    @GetMapping("getOrderByProductId/{id}")
    public ResponseEntity<Object> getOrderByProductId(@PathVariable Long id){
        return pedidoService.getByIdProduto(id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id){
        return pedidoService.delete(id);
    }
}

