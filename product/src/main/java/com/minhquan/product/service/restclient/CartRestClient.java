package com.minhquan.product.service.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cart")
public interface CartRestClient {
    @PostMapping("/api/v1/cart/")
    public ResponseEntity<String> getHello(@RequestBody String hello);
}
