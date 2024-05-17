package com.minhquan.product.mapper;

import org.mapstruct.Mapper;

import com.minhquan.product.dto.ProductDto;
import com.minhquan.product.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product entity);
    Product toEntity(ProductDto dto);
}
