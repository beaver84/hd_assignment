package com.hdjuction.project.controller;

import com.hdjuction.project.model.dto.PatientRequest;
import com.hdjuction.project.model.dto.PatientResponse;
import com.hdjuction.project.model.entity.Patient;
import com.hdjuction.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public Patient getPatientDetail(
            @PathVariable(name = "id")
            Long id) {
        return patientService.getPatientDetail(id);
    }

    @PostMapping
    public Long addPatient(
            @RequestBody
            PatientRequest patientRequest) {
        return patientService.addPatient(patientRequest);
    }

    @PutMapping("/{id}")
    public Long modifyPatient(
            @PathVariable(name = "id")
            Long id,
            @RequestBody
            PatientRequest patientRequest) {
        return patientService.modifyPatient(id, patientRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(
            @PathVariable(name = "id")
            Long id) {
        patientService.deletePatient(id);
    }

    @Description("환자 조회")
    @GetMapping("/{id}/details")
    public PatientResponse getPatientAndVisitInfo(
            @PathVariable(name = "id")
            Long id) {
        return patientService.getPatientAndVisitInfo(id);
    }

    @Description("환자 목록 조회")
    @GetMapping("/all")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }
}
