package com.mrthinkj.kythucac.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotNumberSpecialValidator implements ConstraintValidator<NotNumberSpecial, String> {
    private String source;
    private Pattern pattern;
    private Matcher matcher;
    private static final String PATTERN = "^[^\\d!@#$%^&*()_+={}\\[\\]:;\"'<>,.?\\\\|`~]*$";
    @Override
    public void initialize(NotNumberSpecial constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.source = constraintAnnotation.source();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validate(value);
    }

    private boolean validate(String value){
        pattern = Pattern.compile(PATTERN);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
