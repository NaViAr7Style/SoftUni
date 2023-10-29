package org.softuni.mobilele.models.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearNotInTheFutureValidator implements ConstraintValidator<YearNotInTheFuture, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        int currentYear = Year.now().getValue();

        return value.intValue() <= currentYear;
    }
}
