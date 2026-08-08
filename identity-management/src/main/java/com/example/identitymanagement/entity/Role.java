package com.example.identitymanagement.entity;

import com.example.sharedkernel.entity.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name"),
                @UniqueConstraint(columnNames = "role_level")
})
public class Role extends BaseAuditEntity {
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private Long roleLevel;

    @NotBlank
    private String description;

    private Boolean canDelete = false;

    private Boolean canUpdate = false;
}
