package com.minhquan.product.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhquan.common.exception.custom.AppInternalException;
import com.minhquan.product.dto.BuildVersion;
import com.minhquan.product.dto.ProductDto;
import com.minhquan.product.service.impl.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/product/")
@Validated
public class ProductResource {

    private final ProductService service;
    private BuildVersion buildVesion;

    @Autowired
    public ProductResource(BuildVersion version, ProductService service) {
        this.service = service;
        this.buildVesion = version;
    }

    @Operation(summary = "POST endpoint to create new Product", description = "Create new Product and save")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Successful operation",
            content = @Content(schema = @Schema(implementation = String.class))
        )
    })
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDto dto) {
        try {
            this.service.save(dto);
        } catch (Exception e) {
            log.error("Fail to add new product ");
            throw new AppInternalException(1, e.getMessage());
        }
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Successfully created new product");
    }

    @GetMapping("/build-version")
    public ResponseEntity<String> getBuildVersion() {
        return ResponseEntity.ok(this.buildVesion.getVersion());
    }
}
