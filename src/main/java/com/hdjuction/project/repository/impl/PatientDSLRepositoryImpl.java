package com.hdjuction.project.repository.impl;

import com.hdjuction.project.model.entity.Patient;
import com.hdjuction.project.model.entity.QPatient;
import com.hdjuction.project.repository.PatientDSLRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class PatientDSLRepositoryImpl extends QuerydslRepositorySupport
    implements PatientDSLRepository {

    @PersistenceContext(name = "entityManager")
    private EntityManager entityManager;

    @Autowired
    public PatientDSLRepositoryImpl() {
        super(Patient.class);
    }

    @Override
    public Page<Patient> findAllV2(String patientName, String patientNo, String birthday, Pageable pageable) {
        QPatient qPatient = QPatient.patient;

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        JPAQuery query = jpaQueryFactory
            .selectFrom(qPatient)
            .where(eqPatientName(patientName)
                    ,eqPatientNo(patientNo)
                    ,eqBirthday(birthday)
            );

        Long totalCount = jpaQueryFactory.select(qPatient.patientId.count())
            .from(qPatient)
            .where(eqPatientName(patientName)
                    ,eqPatientNo(patientNo)
                    ,eqBirthday(birthday)).fetchOne();

        List<Patient> users = getQuerydsl().applyPagination(pageable, query).fetch();

        return new PageImpl<>(users, pageable, totalCount);
    }

    private BooleanExpression eqPatientName(String patientName) {
        QPatient qPatient = QPatient.patient;
        if (StringUtils.isEmpty(patientName)) {
            return null;
        }
        return qPatient.patientName.eq(patientName);
    }

    private BooleanExpression eqPatientNo(String patientNo) {
        QPatient qPatient = QPatient.patient;
        if (StringUtils.isEmpty(patientNo)) {
            return null;
        }
        return qPatient.patientNo.eq(patientNo);
    }

    private BooleanExpression eqBirthday(String birthday) {
        QPatient qPatient = QPatient.patient;
        if (StringUtils.isEmpty(birthday)) {
            return null;
        }
        return qPatient.birthday.eq(birthday);
    }
}
