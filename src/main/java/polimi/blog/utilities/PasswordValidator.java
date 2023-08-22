package polimi.blog.utilities;

public class PasswordValidator {
    public static boolean isPasswordSecure(String password) {
    	
        // Definisci i criteri minimi di sicurezza
        int minLength = 8;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialCharacters = "!@#$%^&*()_+{}[]:;<>,.?/~";

        if (password.length() < minLength) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialCharacters.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
}
