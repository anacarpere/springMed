package med.voll.api.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EmailConstraintException.class)
    public ResponseEntity<Object> handleEmailConstraintException(EmailConstraintException ex) {
        // Create a custom error response or handle the exception as needed
        String errorMessage = "Email constraint violated: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
