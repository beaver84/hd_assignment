package com.hdjuction.project.model.repository;

import com.hdjuction.project.model.entity.code.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, String> {
}
