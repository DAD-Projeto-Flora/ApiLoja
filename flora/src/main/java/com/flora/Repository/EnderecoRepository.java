package com.flora.Repository;

import com.flora.Model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
    List<EnderecoModel> findByClienteId(Long clienteId);
}
