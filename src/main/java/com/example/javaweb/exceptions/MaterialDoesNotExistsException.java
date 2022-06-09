package com.example.javaweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MaterialDoesNotExistsException extends RuntimeException{
    public MaterialDoesNotExistsException(Integer id) {
        super(String.format("Material with id: %d is not found", id));
    }
}

