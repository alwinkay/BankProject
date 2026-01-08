import java.util.Scanner;

/**
 * BankApp is the main class that runs the Simple Banking System.
 * It displays a menu and allows the user to deposit, withdraw,
 * check balance, or exit the program.
 */
public class BankApp {

    public static void main(String[] args) {

        // Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Ask for account holder name
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        // Asks the user to create a pin
        System.out.print("Create a 4-digit PIN: ");
        int pin = readInt(scanner);

        // creating BankAccount object
        BankAccount account = new BankAccount(name, 0.0, pin);

        // Variable to store user's menu choice
        int choice;

        // login attempts
        int attempts = 0;
        boolean authenticated = false;

        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            int enteredPin = readInt(scanner);

            if (account.verifyPin(enteredPin)) {
                authenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }

        if (!authenticated) {
            System.out.println("Account locked. Too many failed attempts.");
            scanner.close();
            return;
        }


        // Loop keeps running until user chooses to exit
        do {
            // Display menu options
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Read user choice safely
            choice = readInt(scanner);

            // Handle user choice
            switch (choice) {
                case 1:
                    // Deposit money
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = readDouble(scanner);
                    account.deposit(depositAmount);
                    break;

                case 2:
                    // Withdraw money
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = readDouble(scanner);
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    // Display current balance
                    System.out.println("Current balance: $" + account.getBalance());
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the banking system.");
                    break;

                default:
                    // Handle invalid menu option
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4); // Continue until exit option is chosen

        // Close the scanner to free resources
        scanner.close();
    }

    /**
     * Reads a valid integer from the user.
     * Prevents program crashes due to invalid input.
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // Discard invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        return value;
    }

    /**
     * Reads a valid double value from the user.
     * Used for deposit and withdrawal amounts.
     */
    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid amount: ");
            scanner.next(); // Discard invalid input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        return value;
    }
}


