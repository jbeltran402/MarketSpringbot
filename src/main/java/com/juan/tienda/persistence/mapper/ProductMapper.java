package com.juan.tienda.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.juan.tienda.domain.Product;
import com.juan.tienda.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "idProducto", target = "producId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "precioVenta", target = "price"),
        @Mapping(source = "cantidadStock", target = "stock"),
        @Mapping(source = "estado", target = "active"),
        @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);
    
    List<Product> toProducts(List<Producto> productos);

    @InheritConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProduct(Product product);

}