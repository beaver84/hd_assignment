package com.hdjuction.project.controller;

import com.hdjuction.project.model.dto.VisitRequest;
import com.hdjuction.project.model.entity.Visit;
import com.hdjuction.project.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
@Validated
public class VisitController {
    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/{id}")
    public Visit getVisitDetail(
            @PathVariable(name = "id")
            Long id) {
        return visitService.getVisitDetail(id);
    }

    @GetMapping("/all")
    public List<Visit> getVisits() {
        return visitService.getVisits();
    }

    @PostMapping
    public Long addVisit(
            @RequestBody
            VisitRequest visitRequest) {
        return visitService.addVisit(visitRequest);
    }

    @PutMapping("/{id}")
    public Long modifyVisit(
            @PathVariable(name = "id")
            Long id,
            @RequestBody
            VisitRequest visitRequest) {
        return visitService.modifyVisit(id, visitRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteVisit(
            @PathVariable(name = "id")
            Long id) {
        visitService.deleteVisit(id);
    }
}
