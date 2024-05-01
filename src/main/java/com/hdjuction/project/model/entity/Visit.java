package com.hdjuction.project.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id", nullable = false)
    private Long visitId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @JsonIgnore
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @JsonIgnore
    private Patient patient;

    @Column(name = "receipt_date", nullable = false, length = 20)
    private String receiptDate;

    @Column(name = "visit_status_code", nullable = false, length = 10)
    private String visitStatusCode;

    @Builder
    public Visit(Long visitId, Hospital hospital, Patient patient, String receiptDate, String visitStatusCode) {
        this.visitId = visitId;
        this.hospital = hospital;
        this.patient = patient;
        this.receiptDate = receiptDate;
        this.visitStatusCode = visitStatusCode;
    }

    public Visit() {}
}
