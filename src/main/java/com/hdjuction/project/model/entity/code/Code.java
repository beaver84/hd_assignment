package com.hdjuction.project.model.entity.code;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "code")
public class Code {
    @Id
    @Column(name = "code", nullable = false, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_group", referencedColumnName = "code_group", nullable = false)
    private CodeGroup codeGroup;

    @Column(name = "code_name", nullable = false, length = 10)
    private String codeName;

    protected Code() {}

    public Code(String code, CodeGroup codeGroup, String codeName) {
        this.code = code;
        this.codeGroup = codeGroup;
        this.codeName = codeName;
    }
}
