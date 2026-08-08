package com.example.sharedkernel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseAuditEntityDTO extends BaseEntityDTO {
    private Instant createdDate;
    private String createdBy;
    private Instant lastModifiedDate;
    private String lastModifiedBy;
    private Instant deletedDate;
    private String deletedBy;
}
