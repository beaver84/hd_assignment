package com.hdjuction.project.repository;

import com.hdjuction.project.model.entity.code.CodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupRepository extends JpaRepository<CodeGroup, String> {
}
