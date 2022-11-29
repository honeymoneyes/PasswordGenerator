import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(new PasswordGenerator(8).getPassword());
    }
}

class PasswordGenerator {
    private String password;
    private int passwordLength;
    private Random random;

    public PasswordGenerator(int passwordLength) {

        if (passwordLength >= 8 && passwordLength <= 14) {
            this.passwordLength = passwordLength;
            random = new Random();
        } else {
            throw new IllegalArgumentException("The password must contain at least 8 characters and no more than 14");
        }
    }

    private void generate() {
        String alphabetForPassword = "!@#$%^&*()_?>< 1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < passwordLength; i++) {
            sb.append(alphabetForPassword.charAt(random.nextInt(alphabetForPassword.length())));
        }
        password = sb.toString();
    }

    public String getPassword() {
        generate();
        return password;
    }
}