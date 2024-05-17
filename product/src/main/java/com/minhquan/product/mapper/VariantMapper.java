package com.minhquan.product.mapper;

import org.mapstruct.Mapper;

import com.minhquan.product.dto.VariantDto;
import com.minhquan.product.entity.Variant;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    VariantDto toDto(Variant entity);
    Variant toEntity(VariantDto dto);
}
