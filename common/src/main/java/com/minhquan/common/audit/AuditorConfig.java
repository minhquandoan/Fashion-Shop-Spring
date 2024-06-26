package com.minhquan.common.audit;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class AuditorConfig {

    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return new AuditAwareImpl();
    }    
}
