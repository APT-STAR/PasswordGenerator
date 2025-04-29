import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PasscodeGenerator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numbers = "0123456789";
            String specialChars = "~!@#$%^&*()";
            
            System.out.print("How many letters do you want? ");
            int letterCount = getPositiveInt(scanner);
            
            System.out.print("How many numbers do you want? ");
            int numberCount = getPositiveInt(scanner);
            
            System.out.print("How many special characters do you want? ");
            int specialCount = getPositiveInt(scanner);
            
            ArrayList<Character> passwordChars = new ArrayList<>();
            Random random = new Random();
            
            for (int i = 0; i < letterCount; i++) {
                passwordChars.add(letters.charAt(random.nextInt(letters.length())));
            }
            
            for (int i = 0; i < numberCount; i++) {
                passwordChars.add(numbers.charAt(random.nextInt(numbers.length())));
            }
            
            for (int i = 0; i < specialCount; i++) {
                passwordChars.add(specialChars.charAt(random.nextInt(specialChars.length())));
            }
            
            Collections.shuffle(passwordChars);
            
            StringBuilder password = new StringBuilder();
            for (char ch : passwordChars) {
                password.append(ch);
            }
            
            System.out.println("\nGenerated Password: " + password.toString());
        }
    }

    // Helper method to safely get positive integers
    private static int getPositiveInt(Scanner scanner) {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= 0) {
                    break;
                } else {
                    System.out.print("Please enter a non-negative number: ");
                }
            } else {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // Clear invalid input
            }
        }
        return num;
    }
}
