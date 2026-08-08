package com.example.identitymanagement.dto;

import com.example.sharedkernel.dto.BaseAuditEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends BaseAuditEntityDTO {
    private String name;
    private Long roleLevel;
    private String description;
    private Boolean canDelete;
    private Boolean canUpdate;
}
