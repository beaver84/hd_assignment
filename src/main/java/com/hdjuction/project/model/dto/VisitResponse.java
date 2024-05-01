package com.hdjuction.project.model.dto;

import com.hdjuction.project.model.entity.Hospital;
import com.hdjuction.project.model.entity.Patient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class VisitResponse {
    private Long visitId;

    private List<Hospital> hospitalList;

    private List<Patient> patientList;

    private String receiptDate;

    private String visitStatusCode;

    @Builder
    public VisitResponse(Long visitId, List<Hospital> hospitalList, List<Patient> patientList, String receiptDate, String visitStatusCode) {
        this.visitId = visitId;
        this.hospitalList = hospitalList;
        this.patientList = patientList;
        this.receiptDate = receiptDate;
        this.visitStatusCode = visitStatusCode;
    }
}
