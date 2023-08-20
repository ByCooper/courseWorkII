package ru.ByCooper.generatorExamQuestion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MathNullException extends RuntimeException{
    public MathNullException() {
    }

    public MathNullException(String message) {
        super(message);
    }

    public MathNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathNullException(Throwable cause) {
        super(cause);
    }

    public MathNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
