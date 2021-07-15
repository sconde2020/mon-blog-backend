package com.soul.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchPostException extends RuntimeException {

    public NoSuchPostException(String s) {
        super(s);
    }
}
