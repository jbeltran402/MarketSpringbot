package com.juan.tienda.persistence;

import java.util.List;
import java.util.Optional;

import com.juan.tienda.persistence.crud.ProductoCrudRepository;
import com.juan.tienda.persistence.entity.Producto;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getBycategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrdeByNombreAsc(idCategoria);
    }

    public List<Producto> getBycategoriaQuery(int idCategoria){
        return productoCrudRepository.findByIdCategoriaQuery(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(Integer cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
