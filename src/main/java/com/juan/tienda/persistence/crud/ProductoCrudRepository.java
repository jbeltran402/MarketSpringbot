package com.juan.tienda.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.juan.tienda.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
}
