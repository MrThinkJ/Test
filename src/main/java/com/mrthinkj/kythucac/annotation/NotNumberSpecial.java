package com.mrthinkj.kythucac.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNumberSpecialValidator.class)
@Documented
public @interface NotNumberSpecial {
    String source();
    String message() default "{source} không được chứa ký tự đặc biệt hoặc số";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
