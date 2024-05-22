package com.minhquan.cart.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/cart/")
public class CartResource {

    @PostMapping
    public ResponseEntity<String> getHello(@RequestBody String hello) {
        log.info("Hello from client: {}", hello);
        return ResponseEntity.ok("Hello From Server");
    }
    
}
