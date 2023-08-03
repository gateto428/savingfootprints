package com.savingfootprints.controllers.service;

import com.savingfootprints.model.ExceptionFootPrints;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static com.savingfootprints.model.enums.ExceptionEnum.BODY_MISSING;

@Component
@RequiredArgsConstructor
@Log
public class ValidatorHandler {
    private final Validator validator;

    private <T> void validateConstraints(Set<ConstraintViolation<T>> constraint){
        if(!constraint.isEmpty()){
            log.log(Level.WARNING, getMessage(constraint), BODY_MISSING);
            throw new ExceptionFootPrints(getMessage(constraint), BODY_MISSING);
        }
    }

    public <T> void validateObject(T object){
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        validateConstraints(violations);
    }

    public <T> void validateObject(T object, Class<?> clazz){
        Set<ConstraintViolation<T>> violations = validator.validate(object, clazz);
        validateConstraints(violations);
    }


    private <T> String getMessage(Set<ConstraintViolation<T>> violations){
        return violations.stream()
                .map(c -> String.join(" ", c.getPropertyPath().toString(), c.getMessage()))
                .collect(Collectors.joining(", "));
    }
}