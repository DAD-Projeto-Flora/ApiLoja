package com.flora.Repository;

import com.flora.Model.CategoriaModel;
import com.flora.Model.PedidoModel;
import com.flora.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    List<ProdutoModel> findByCategoriaId(int categoriaId);
}
