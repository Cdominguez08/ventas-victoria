package com.ventas.victoria.persitence.mapper;

import com.ventas.victoria.domain.Category;
import com.ventas.victoria.persitence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
        componentModel = "spring"
)
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //hace la conversion viceversa previamente mapeada arriba
    @Mapping(target = "productos", ignore = true) //con esto le decimos a mapper que el atributo productos de Categoria no lo mape con nada, ya que no tenemos nada en Category
    Categoria toCategoria(Category category);
}
