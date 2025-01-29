package com.godbyul.first_project.exceptions;

public class UserException extends RuntimeException {
    public static final String USER_NOT_FOUND_MESSAGE = "User not found";

    public UserException(String message) {
        super(message);
    }
}
