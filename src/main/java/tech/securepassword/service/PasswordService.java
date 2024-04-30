package tech.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePass(String pass) {
        List<String> failures = new ArrayList<>();

        validateLength(pass, failures);
        validateLowercase(pass, failures);
        validateUppercase(pass, failures);
        validateNumber(pass, failures);
        validateSpecialCharacter(pass, failures);

        return failures;
    }

    private void validateLength(String pass, List<String> failures) {
        if (pass != null && pass.length() < 8) {
            failures.add("The password must be at least 8 characters long.");
        }
    }

    private void validateLowercase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[a-z].*", pass)) {
            failures.add("The password must have at least one lowercase letter.");
        }
    }

    private void validateUppercase(String pass, List<String> failures) {
        if (!Pattern.matches(".*[A-Z].*", pass)) {
            failures.add("The password must have at least one uppercase letter.");
        }
    }

    private void validateNumber(String pass, List<String> failures) {
        if (!Pattern.matches(".*[0-9].*", pass)) {
            failures.add("The password must have at least one numeric digit.");
        }
    }

    private void validateSpecialCharacter(String pass, List<String> failures) {
        if (!Pattern.matches(".*[\\W].*", pass)) {
            failures.add("The password must have at least one special character. (e.g., !@#$%)");
        }
    }


}

