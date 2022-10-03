package com.juan.tienda.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.tienda.domain.Product;
import com.juan.tienda.domain.repository.ProducRepository;



@Service
public class ProductService {

    @Autowired
    private ProducRepository producRepository;

    public List<Product> getAll() {
        return producRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return producRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return producRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return producRepository.save(product);
    }

    public boolean delete(int producId){
        return getProduct(producId).map(produc -> {
            producRepository.delete(producId);
            return true;
        }).orElse(false);
    }
}
