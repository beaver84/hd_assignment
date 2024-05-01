package com.hdjuction.project.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id", nullable = false)
    private Long hospitalId;

    @Column(name = "hospital_name", nullable = false, length = 45)
    private String hospitalName;

    @Column(name = "medical_care_no", nullable = false, length = 20)
    private String medicalCareNo;

    @Column(name = "hospital_chief_name", nullable = false, length = 10)
    private String hospitalChiefName;

    @Builder
    public Hospital(Long hospitalId, String hospitalName, String medicalCareNo, String hospitalChiefName) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.medicalCareNo = medicalCareNo;
        this.hospitalChiefName = hospitalChiefName;
    }

    public Hospital() {

    }
}
