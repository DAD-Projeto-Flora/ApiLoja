package com.flora.Repository;

import com.flora.Model.CartaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<CartaoModel, Long> {
    List<CartaoModel> findByClienteId(Long clienteId);
}
