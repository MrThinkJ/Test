package com.mrthinkj.kythucac.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListMaxValidator.class)
public @interface ListMax {
    int value();
    String message() default "Danh sách thể loại không được nhiều hơn {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


