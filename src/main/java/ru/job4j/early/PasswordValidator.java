package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};
    private static final String NULL_PASSWORD_MESSAGE = "Password can't be null";
    private static final String LENGTH_ERROR_MESSAGE = "Password should be length [8, 32]";
    private static final String FORBIDDEN_MESSAGE = "Password shouldn't contain substrings: qwerty, 12345, password, admin, user";
    private static final String UPPERCASE_ERROR_MESSAGE = "Password should contain at least one uppercase letter";
    private static final String LOWER_ERROR_MESSAGE = "Password should contain at least one lowercase letter";
    private static final String DIGIT_ERROR_MESSAGE = "Password should contain at least one figure";
    private static final String SYMBOL_ERROR_MESSAGE = "Password should contain at least one special symbol";

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(NULL_PASSWORD_MESSAGE);
        }
        if (password.length() > 32 || password.length() < 8) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }

        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                hasUpCase = true;
            } else if
            (Character.isLowerCase(symbol)) {
                hasLowCase = true;
            } else if (Character.isDigit(symbol)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(symbol)) {
                hasSpecial = true;
            }
            if (hasUpCase && hasLowCase && hasDigit && hasSpecial) {
                break;
            }
        }

        String lowerCasePassword = password.toLowerCase();
        for (String forbiddenWords : FORBIDDEN) {
            if (lowerCasePassword.contains(forbiddenWords)) {
                throw new IllegalArgumentException(FORBIDDEN_MESSAGE);
            }
        }

        if (!hasUpCase) {
            throw new IllegalArgumentException(UPPERCASE_ERROR_MESSAGE);
        }

        if (!hasLowCase) {
            throw new IllegalArgumentException(LOWER_ERROR_MESSAGE);
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(SYMBOL_ERROR_MESSAGE);
        }
        return password;
    }
}
