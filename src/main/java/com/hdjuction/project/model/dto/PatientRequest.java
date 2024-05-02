package com.hdjuction.project.model.dto;

import com.hdjuction.project.config.validator.StringNotEmpty;
import com.hdjuction.project.model.entity.Hospital;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {

    private Hospital hospital;

    @StringNotEmpty(message = "환자 이름을 입력해주세요")
    private String patientName;

    @StringNotEmpty(message = "환자 번호를 입력해주세요")
    private String patientNo;

    @StringNotEmpty(message = "성별 코드를 입력해주세요")
    private String sexCode;

    @StringNotEmpty(message = "생일을 입력해주세요")
    private String birthday;

    @StringNotEmpty(message = "전화번호를 입력해주세요")
    private String telNo;
}
