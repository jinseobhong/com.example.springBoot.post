package com.example.post.exception;

public class UserNotFoundException extends DefaultException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String title, String message) {
        super(title, message);
    }

    public UserNotFoundException(String title, String message, String detailedMessage) {
        super(title, message, detailedMessage);
    }
}
