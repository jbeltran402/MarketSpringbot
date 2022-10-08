package com.juan.tienda.domain.repository;

import java.util.List;
import java.util.Optional;

import com.juan.tienda.domain.Product;

public interface ProducRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getByCategoryQuery(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int producId);
    Product save(Product product);
    void delete(int producId);
}
