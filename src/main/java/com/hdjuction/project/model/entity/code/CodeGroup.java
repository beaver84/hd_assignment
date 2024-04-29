package com.hdjuction.project.model.entity.code;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "code_group")
public class CodeGroup {
    @Id
    @Column(name = "code_group", nullable = false, length = 10)
    private String codeGroup;

    @Column(name = "code_group_name", nullable = false, length = 10)
    private String codeGroupName;

    @Column(name = "description", nullable = false, length = 10)
    private String description;

    protected CodeGroup(){}

    public CodeGroup(String codeGroup, String codeGroupName, String description) {
        this.codeGroup = codeGroup;
        this.codeGroupName = codeGroupName;
        this.description = description;
    }
}
