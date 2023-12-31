package ru.ByCooper.generatorExamQuestion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongVolumeException extends RuntimeException{
    public WrongVolumeException() {
    }

    public WrongVolumeException(String message) {
        super(message);
    }

    public WrongVolumeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongVolumeException(Throwable cause) {
        super(cause);
    }

    public WrongVolumeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
