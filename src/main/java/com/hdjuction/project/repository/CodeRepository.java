package com.hdjuction.project.repository;

import com.hdjuction.project.model.entity.code.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, String> {
}
