package com.hdjuction.project.service;

import com.hdjuction.project.config.exception.ApiException;
import com.hdjuction.project.model.dto.VisitRequest;
import com.hdjuction.project.model.entity.Visit;
import com.hdjuction.project.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit getVisitDetail(Long id) {
        return visitRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "계정을 찾을 수 없습니다."));
    }

    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    public Long addVisit(VisitRequest visitRequest) {
        Visit visit = new Visit();

        Visit visitBuilder = visit.builder().visitStatusCode(visitRequest.getVisitStatusCode())
                .receiptDate(visitRequest.getReceiptDate())
                .build();
        visitRepository.save(visitBuilder);
        return 1L;
    }

    public Long modifyVisit(Long id, VisitRequest visitRequest) {
        Visit visit = visitRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "방문 데이터를 찾을 수 없습니다."));

        Visit visitBuilder = visit.builder().visitStatusCode(visitRequest.getVisitStatusCode())
                .receiptDate(visitRequest.getReceiptDate())
                .build();
        visitRepository.save(visitBuilder);
        return 1L;
    }

    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
