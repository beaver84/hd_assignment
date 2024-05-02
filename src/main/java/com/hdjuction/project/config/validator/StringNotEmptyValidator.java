package com.hdjuction.project.config.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringNotEmptyValidator implements ConstraintValidator<StringNotEmpty, String> {
    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isNotEmpty(target);
    }
}
