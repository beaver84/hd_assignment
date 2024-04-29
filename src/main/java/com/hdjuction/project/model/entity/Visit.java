package com.hdjuction.project.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id", nullable = false)
    private Long visitId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "receipt_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receiptDate;

    @Column(name = "visit_status_code", nullable = false, length = 10)
    private String visitStatusCode;

    public Visit(Long visitId, Hospital hospital, Patient patient, LocalDateTime receiptDate, String visitStatusCode) {
        this.visitId = visitId;
        this.hospital = hospital;
        this.patient = patient;
        this.receiptDate = receiptDate;
        this.visitStatusCode = visitStatusCode;
    }

    protected Visit() {}
}
