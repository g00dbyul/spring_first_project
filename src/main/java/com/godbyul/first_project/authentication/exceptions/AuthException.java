package com.godbyul.first_project.authentication.exceptions;

public class AuthException extends RuntimeException {
    public static final String USER_NOT_FOUND_MESSAGE = "User not found";

    public AuthException(String message) {
        super(message);
    }
}
