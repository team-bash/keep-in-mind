package com.teambash.keepinmind.exceptions;

public class ResourceNotFound extends  RuntimeException {
    public ResourceNotFound(String message) {
        super(message+" not found");
    }
}
