package com.juan.tienda.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.juan.tienda.persistence.crud.ProductoCrudRepository;
import com.juan.tienda.persistence.entity.Producto;

@Repository
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

    public Optional<Producto> getProducto(Integer idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
