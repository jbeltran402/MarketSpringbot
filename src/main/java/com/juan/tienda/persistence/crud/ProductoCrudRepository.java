package com.juan.tienda.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.juan.tienda.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

    @Query(value = "SELECT * FROM productos WHERE id_categoria + ?", nativeQuery = true)
    List<Producto> findByIdCategoriaQuery(Integer idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock,boolean estado);
}
