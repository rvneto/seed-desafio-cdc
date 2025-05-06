package com.rvneto.casadocodigo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        // Mensagem personalizada, pode extrair detalhes do ex.getMessage()
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Violação de restrição de unicidade: valor já cadastrado.");
    }
}
