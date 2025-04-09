package com.flora.Repository;

import com.flora.Model.ClienteModel;
import com.flora.Model.PedidoModel;
import com.flora.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    List<PedidoModel> findByClienteId(Long id);
    List<PedidoModel> findByProdutoId(Long id);
}
