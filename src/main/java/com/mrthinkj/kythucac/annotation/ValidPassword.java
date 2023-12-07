package com.mrthinkj.kythucac.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Mật khẩu chứa ít nhất 1 kí tự hoa, 1 kí tự thường, 1 số và 1 kí tự đặc biệt";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
