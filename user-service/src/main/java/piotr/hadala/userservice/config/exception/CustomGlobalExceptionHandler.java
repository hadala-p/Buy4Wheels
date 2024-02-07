package piotr.hadala.userservice.config.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Sprawdź, czy to naruszenie unikalności adresu email
        if (ex.getMostSpecificCause().getMessage().contains("CONSTRAINT_INDEX_4")) {
            // Zwróć odpowiedni status HTTP i komunikat
            String errorMessage = "This email address is already in use. Please use a different email address.";
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT); // 409 Conflict
        }
        // Domyślna obsługa dla innych przypadków naruszeń integralności danych
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
