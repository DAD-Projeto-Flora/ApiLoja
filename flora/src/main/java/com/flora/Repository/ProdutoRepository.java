package com.flora.Repository;

import com.flora.Model.PedidoModel;
import com.flora.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
