package com.finance.common.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    /** 생성 시각(감사/재현/추적용) */
    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private Instant createdAt;

    /** 수정 시각(감사/재현/추적용) */
    @Column(name = "UpdatedAt")
    private Instant updatedAt;

    @PrePersist
    void prePersist() {
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    void preUpdate() {
        this.updatedAt = Instant.now();
    }
}