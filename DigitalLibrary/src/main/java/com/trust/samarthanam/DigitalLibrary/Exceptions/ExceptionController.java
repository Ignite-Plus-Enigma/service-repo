package com.trust.samarthanam.DigitalLibrary.Exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<Object> exception(BookNotFoundException exception) {
        return new ResponseEntity<>("Sorry!! Book not available", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("Sorry!! User not available", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<Object> exception(CategoryNotFoundException exception) {
        return new ResponseEntity<>("Sorry!! Category not available", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Object> exception(InvalidIdException exception) {
        return new ResponseEntity<>("Invalid ID", HttpStatus.NOT_FOUND);
    }

}

