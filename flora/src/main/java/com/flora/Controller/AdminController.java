package com.flora.Controller;

import com.flora.Model.AdminModel;
import com.flora.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/saveAdmin")
    public ResponseEntity<String> saveAdmin(@RequestBody AdminModel adminModel){
        return adminService.save(adminModel);
    }

    @GetMapping("/getAdmins")
    public ResponseEntity<List<AdminModel>> getAllAdmins() {
        return adminService.getAll();
    }

    @GetMapping("/getAdmin/{id}")
    public ResponseEntity<Object> getAdminById(@PathVariable int id){
        return adminService.getById(id);
    }


    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable int id, @RequestBody AdminModel adminModel){
        return adminService.update(id, adminModel);
    }

    @PatchMapping("/partialUpdateAdmin/{id}")
    public ResponseEntity<String> partialUpdateAdmin(@PathVariable int id, @RequestBody Map<Object, Object> updates){
        return adminService.partialUpdate(id, updates);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable int id){
        return adminService.delete(id);
    }
}

