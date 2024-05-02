package com.hdjuction.project.model.dto;

import com.hdjuction.project.model.entity.Visit;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class PatientResponse {
    private String patientName;

    private String patientNo;

    private String sexCode;

    private String birthday;

    private String telNo;

    private List<Visit> visitList;

    @Builder
    public PatientResponse(String patientName, String patientNo, String sexCode, String birthday, String telNo, List<Visit> visitList) {
        this.patientName = patientName;
        this.patientNo = patientNo;
        this.sexCode = sexCode;
        this.birthday = birthday;
        this.telNo = telNo;
        this.visitList = visitList;
    }
}
