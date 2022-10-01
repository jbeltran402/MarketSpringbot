package com.juan.tienda.persistence;

import java.util.List;

import com.juan.tienda.persistence.crud.ProductoCrudRepository;
import com.juan.tienda.persistence.entity.Producto;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
