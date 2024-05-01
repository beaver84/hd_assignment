package com.hdjuction.project.model.dto;

import com.hdjuction.project.model.entity.Hospital;
import jakarta.persistence.*;
import lombok.Getter;

public class PatientResponse {
    private Long hospitalId;

    private Hospital hospital;

    private String patientName;

    private String patientNo;

    private String sexCode;

    private String birthday;

    private String telNo;

}
