package com.hdjuction.project.model.dto;

import com.hdjuction.project.model.entity.Hospital;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {

    private Hospital hospital;

    private String patientName;

    private String patientNo;

    private String sexCode;

    private String birthday;

    private String telNo;
}
