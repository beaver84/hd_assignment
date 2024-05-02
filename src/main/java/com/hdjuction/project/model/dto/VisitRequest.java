package com.hdjuction.project.model.dto;

import com.hdjuction.project.config.validator.StringNotEmpty;
import com.hdjuction.project.model.entity.Hospital;
import com.hdjuction.project.model.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VisitRequest {

    private Patient patient;

    private Hospital Hospital;

    @StringNotEmpty(message = "날짜를 입력해주세요")
    private LocalDateTime receiptDate;

    @StringNotEmpty(message = "환자 상태코드를 입력해주세요")
    private String visitStatusCode;

}
