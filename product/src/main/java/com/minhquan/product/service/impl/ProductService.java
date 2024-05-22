package com.minhquan.product.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minhquan.common.exception.custom.AppInternalException;
import com.minhquan.product.dto.ProductDto;
import com.minhquan.product.mapper.ProductMapper;
import com.minhquan.product.repository.ProductRepository;
import com.minhquan.product.service.IProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class ProductService implements IProductService {
    private final ProductRepository repo;
    private final ProductMapper mapper;

    @Override
    public void save(ProductDto dto) {
        if (dto == null) {
            log.error("Product Dto is null - can not proccess to save");
            throw new AppInternalException(1, "ffff");
        }

        final var entity = this.mapper.toEntity(dto);
        if (dto.getQuantity() > 0) {
            entity.setOutOfStock(true);
            entity.setActive(true);
        }

        try {
            log.info("Saving product {} to DB", entity);
            this.repo.save(entity);
            log.trace("Save Product {} successfully", entity);
        } catch(Exception e) {
            log.error("Save Product {} unsuccessfully!!!", entity);
            throw new AppInternalException(1, e.getMessage());
        }
    }
    
}
