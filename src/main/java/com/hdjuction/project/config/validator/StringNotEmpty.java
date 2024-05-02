package com.hdjuction.project.config.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringNotEmptyValidator.class)
public @interface StringNotEmpty {
    String message() default "잘못된 요청입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
