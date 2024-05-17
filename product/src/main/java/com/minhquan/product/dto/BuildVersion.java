package com.minhquan.product.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Configuration
@ConfigurationProperties(prefix = "build")
public class BuildVersion {
    private String version;
}
