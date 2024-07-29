package Structural_pattern.Decorator_pattern;

import java.util.*;

public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processMessage(scanner);
    }

    private static void processMessage(Scanner scanner) {
        System.out.println("Enter a message (type 'exit' to quit): ");
        String input = scanner.nextLine();

        if ("exit".equalsIgnoreCase(input)) {
            System.out.println("Exiting...");
            return;
        }

        Message simpleMessage = new SimpleMessage(input);

        Message encryptedMessage = new EncryptionDecorator(simpleMessage);
        System.out.println("Encrypted Message: " + encryptedMessage.getContent());

        Message decryptedMessage = new DecryptionDecorator(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage.getContent());

        // Recursive call
        processMessage(scanner);
    }
}