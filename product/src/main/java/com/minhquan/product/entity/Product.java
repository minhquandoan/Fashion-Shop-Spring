package com.minhquan.product.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.minhquan.common.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String sku;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    private String slug;

    @Column(name = "short_description")
    private String shortDescription;

    private String note;

    private int quantity;

    @Column(name = "compare_price")
    private BigDecimal comparePrice;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice; // Buying Price

    @Column(name = "disable_out_of_stock")
    private boolean isOutOfStock;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
    private Variant variant;
}
