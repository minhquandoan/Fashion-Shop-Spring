package com.minhquan.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class ProductDto {

    private UUID id;

    @NotBlank
    @Length(max = 50, message = "Name should contain less than 50 characters")
    private String name;

    @Length(max = 300, message = "Content should contain less than 300 characters")
    private String description;

    private String slug;

    private String sku;

    private String shortDescription;

    private String note;

    private int quantity;

    private BigDecimal comparePrice;

    private BigDecimal salePrice;

    private BigDecimal currentPrice;

    // private VariantDto variant;
}
