import java.util.Scanner;

public class PasswordStrengthChecker {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        int strengthScore = calculatePasswordStrength(password);
        
        String strengthMessage = getStrengthMessage(strengthScore);
        System.out.println("Password Strength: " + strengthMessage);
        
        scanner.close();
    }
    
    private static int calculatePasswordStrength(String password) {
        int score = 0;
        
        if (password.length() >= 8) {
            score++;
        }
        
        if (password.matches(".*[A-Z].*")) {
            score++;
        }
        
        if (password.matches(".*[a-z].*")) {
            score++;
        }
        
        if (password.matches(".*\\d.*")) {
            score++;
        }
        
        if (password.matches(".*[!@#$%^&*()-+].*")) {
            score++;
        }
        
        return score;
    }
    
    private static String getStrengthMessage(int score) {
        switch (score) {
            case 5:
                return "Very Strong";
            case 4:
                return "Strong";
            case 3:
                return "Moderate";
            case 2:
                return "Weak";
            case 1:
                return "Very Weak";
            default:
                return "Extremely Weak";
        }
    }
}
