package com.juan.tienda.persistence.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.juan.tienda.domain.Category;
import com.juan.tienda.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "descripcion", target = "category"),
        @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritConfiguration
    @Mapping(target = "products", ignore = true)
    Categoria tCategoria(Category category);
}
