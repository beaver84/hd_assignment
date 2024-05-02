package com.hdjuction.project.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPatientRequest {
    private String patientName;

    private String patientNo;

    private String birthday;
}
