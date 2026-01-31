package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    public static void validateName(String name) {
        if (name == null || !name.matches("[A-Za-z]{2,30}")) {
            throw new InvalidInputException("Invalid name!");
        }
    }

    public static void validateEmail(String email) {
        if (email == null) return;

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidInputException("Invalid email!");
        }
    }

    public static void validateAge(int age) {
        if (age < 5 || age > 100) {
            throw new InvalidInputException("Invalid age!");
        }
    }

    public static void validateBatch(int batch) {
        if (batch <= 0 || batch > 100) {
            throw new InvalidInputException("Invalid batch!");
        }
    }
}
