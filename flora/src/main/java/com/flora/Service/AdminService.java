package com.flora.Service;

import com.flora.Model.AdminModel;
import com.flora.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity<String> save(AdminModel adminModel){
        try {
            adminRepository.save(adminModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Admin salvo com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível salvar o admin. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<List<AdminModel>> getAll(){
        return ResponseEntity.ok(adminRepository.findAll());
    }

    public ResponseEntity<Object> getById(int id){
        try {
            Optional<AdminModel> admin = adminRepository.findById(id);
            if (admin.isEmpty()){
                return ResponseEntity.badRequest().body("Esse admin ainda não foi cadastrado.");
            }
            return ResponseEntity.ok(admin.get());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível buscar o admin. Exceção: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> update(int id, AdminModel adminModel){
        try {
            Optional<AdminModel> admin = adminRepository.findById(id);
            if (admin.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin não encontrado");
            }
            AdminModel adminToUpdate = (AdminModel) admin.get();

            adminToUpdate.setNome(adminModel.getNome());

            adminRepository.save(adminToUpdate);
            return ResponseEntity.ok("Admin atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Não foi possível atualizar o admin.");
        }
    }

    public ResponseEntity<Object> delete(int id) {
        Optional<AdminModel> admin = adminRepository.findById(id);
        if (admin.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin não encontrado");
        }
        adminRepository.deleteById(id);
        return ResponseEntity.ok("Admin deletado com sucesso!");
    }
}
