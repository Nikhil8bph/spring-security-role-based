package com.example.sharedkernal.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntityDTO {
    private UUID id;
    private String tenantId;
    private Long version = 1L;
    private Boolean isDeleted = false;
    private Boolean isActive = true;
}
