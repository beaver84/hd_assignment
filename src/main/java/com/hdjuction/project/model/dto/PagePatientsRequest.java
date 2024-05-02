package com.hdjuction.project.model.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PagePatientsRequest {

    private int pageNo;

    private int pageSize;

    private Sort.Direction direction;

    private String properties;

    public PagePatientsRequest() {
        this.pageNo = 1;
        this.pageSize = 10;
        this.direction = Sort.Direction.DESC;
        this.properties = "id";
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }
    public Sort.Direction getDirection() {
        return direction;
    }

    public String getProperties() {
        return properties;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo <= 0 ? 1 : pageNo;
    }

    public void setPageSize(int pageSize) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 50;
        this.pageSize = pageSize > MAX_SIZE ? DEFAULT_SIZE : pageSize;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public PageRequest of() {
        return PageRequest.of(pageNo - 1, pageSize, direction, properties);
    }

}
