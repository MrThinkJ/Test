package com.mrthinkj.kythucac.annotation;

import com.mrthinkj.kythucac.model.book.Type;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ListMaxValidator implements ConstraintValidator<ListMax, List<Type>> {
    private int max;
    @Override
    public void initialize(ListMax constraintAnnotation) {
        this.max = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<Type> value, ConstraintValidatorContext context) {
        return value == null || value.size() <= max;
    }
}
