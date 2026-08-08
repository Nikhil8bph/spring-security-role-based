package com.example.sharedkernal.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditEntity extends BaseEntity {

    @CreatedDate
    private Instant createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private Instant lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;

    private Instant deletedDate;
    private String deletedBy;

    public void delete(String deletedBy) {
        this.deletedDate = Instant.now();
        this.deletedBy = deletedBy;
        this.setIsDeleted(true);
        this.setIsActive(false);
    }

    public void restore(String deletedBy) {
        this.deletedDate = null;
        this.deletedBy = null;
        this.setIsDeleted(false);
        this.setIsActive(true);
    }
}
