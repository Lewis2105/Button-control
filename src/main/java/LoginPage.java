import java.util.Scanner;

public class LoginPage {
    public static void main(String[] args) {
        String username = "Kirema"; // This the correct login username
        String password = "12345678"; // This the correct login password
        int maxAttempts = 3; // The number of maximum attempts to be accepted
        int attempts = 0; //This keeps record of the attempts made

        Scanner scanner = new Scanner(System.in);
        
        //The line starts a while loop that will run until the number of login attempts exceeds the maximum allowed attempts 
        while (attempts < maxAttempts) {
            System.out.print("Enter your username: ");
            String enteredUsername = scanner.nextLine();// It prompts the user to input usernames

            System.out.print("Enter your password: ");
            String enteredPassword = readPassword(scanner); //It prompts the user to input password masking the password with *

            // It Checks if the entered username and password are correct
            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                int remainingAttempts = maxAttempts - attempts;
                System.out.println("Incorrect username or password. Remaining attempts: " + remainingAttempts);
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Maximum login attempts exceeded. Please try again later."); // Excecuted when login attempts exeed 
        }

        scanner.close();
    }

    // This method is to read the password character by character and display * instead of the actual characters
    private static String readPassword(Scanner scanner) {
        String password = "";
        char[] passwordChars = scanner.nextLine().toCharArray();
        
        for (char c : passwordChars) {
            System.out.print("*");
            password += c;
        }
        
        return password;
    }
}