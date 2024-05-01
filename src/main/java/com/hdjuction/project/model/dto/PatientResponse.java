package com.hdjuction.project.model.dto;

import com.hdjuction.project.model.entity.Hospital;
import com.hdjuction.project.model.entity.Visit;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientResponse {
    private String patientName;

    private String patientNo;

    private String sexCode;

    private String birthday;

    private String telNo;

    private List<Visit> visitList;

    public PatientResponse() {
    }

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
