package com.minhquan.common.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {
    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name="created_by", updatable = false)
    private UUID createdBy;

    @LastModifiedDate
    @Column(name="updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name="updated_by", insertable = false)
    private UUID updatedBy;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
