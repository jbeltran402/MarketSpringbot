package com.juan.tienda.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.juan.tienda.domain.Product;
import com.juan.tienda.domain.repository.ProducRepository;
import com.juan.tienda.persistence.crud.ProductoCrudRepository;
import com.juan.tienda.persistence.entity.Producto;
import com.juan.tienda.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProducRepository{
    
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;
    
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public void delete(int productoId){
        productoCrudRepository.deleteById(productoId);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto>productos = productoCrudRepository.findByIdCategoriaOrdeByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int producId) {
        return productoCrudRepository.findById(producId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto =mapper.toProduct(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public Optional<List<Product>> getByCategoryQuery(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaQuery(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
}
