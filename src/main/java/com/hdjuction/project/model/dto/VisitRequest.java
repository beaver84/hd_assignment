package com.hdjuction.project.model.dto;

import com.hdjuction.project.model.entity.Hospital;
import com.hdjuction.project.model.entity.Patient;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VisitRequest {

    private Patient patient;

    private Hospital Hospital;

    @Nonnull
    private String receiptDate;

    @Nonnull
    private String visitStatusCode;

}
