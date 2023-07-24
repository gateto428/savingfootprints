package com.savingfootprints.model;

import com.savingfootprints.model.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class ExceptionFootPrints extends RuntimeException{
    private final ExceptionEnum exception;

    public ExceptionFootPrints (Throwable error, ExceptionEnum exception){
        super(error);
        this.exception = exception;
    }

    public ExceptionFootPrints (String message, ExceptionEnum exception){
        super(message);
        this.exception = exception;
    }

    public ExceptionFootPrints (ExceptionEnum exception){
        super(exception.getMessage());
        this.exception = exception;
    }
}
