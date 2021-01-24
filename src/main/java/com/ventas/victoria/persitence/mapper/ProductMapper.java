package com.ventas.victoria.persitence.mapper;

import com.ventas.victoria.domain.Category;
import com.ventas.victoria.domain.Product;
import com.ventas.victoria.persitence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) //con uses, internamente sabra que podra usar CategoryMapper para maperar toda la case categoria-category
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target =  "name"),
            @Mapping(source = "idCategoria", target =  "categoryId"),
            @Mapping(source = "precioVenta", target =  "price"),
            @Mapping(source = "cantidadStock", target =  "stock"),
            @Mapping(source = "estado", target =  "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
