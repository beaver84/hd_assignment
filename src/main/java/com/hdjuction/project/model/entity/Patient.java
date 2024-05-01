package com.hdjuction.project.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long hospitalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @JsonIgnore
    private Hospital hospital;

    @Column(name = "patient_name", nullable = false, length = 45)
    private String patientName;

    @Column(name = "patient_no", nullable = false, length = 13)
    private String patientNo;

    @Column(name = "sex_code", nullable = false, length = 10)
    private String sexCode;

    @Column(name = "birthday", nullable = false, length = 10)
    private String birthday;

    @Column(name = "tel_no", nullable = false, length = 20)
    private String telNo;

    public Patient() {}

    @Builder
    public Patient(Long hospitalId, Hospital hospital, String patientName, String patientNo, String sexCode, String birthday, String telNo) {
        this.hospitalId = hospitalId;
        this.hospital = hospital;
        this.patientName = patientName;
        this.patientNo = patientNo;
        this.sexCode = sexCode;
        this.birthday = birthday;
        this.telNo = telNo;
    }
}
