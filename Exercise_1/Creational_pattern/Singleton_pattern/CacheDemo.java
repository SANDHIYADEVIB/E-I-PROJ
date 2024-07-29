package Creational_pattern.Singleton_pattern;

import java.util.Scanner;

/**
 * Demonstrates the use of CacheManager with recursion.
 */
public class CacheDemo {
    private static final Scanner scanner = new Scanner(System.in);
    private static CacheManager cacheManager = CacheManager.getInstance();

    public static void main(String[] args) {
        runDemo();
    }

    private static void runDemo() {
        // Show menu

        int choice = getUserInput("Enter choice (1-5)--put,get,remove,clear,exit: \n");

        switch (choice) {
            case 1:
                handlePut();
                break;
            case 2:
                handleGet();
                break;
            case 3:
                handleRemove();
                break;
            case 4:
                handleClear();
                break;
            case 5:
                System.out.println("Exiting program.");
                scanner.close();
                return; // Exit the recursion
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }

        // Recursive call to continue the menu until exit
        runDemo();
    }

    private static void handlePut() {
        String key = getUserInputString("Enter key to put: ");
        String value = getUserInputString("Enter value to put: ");
        cacheManager.put(key, value);
    }

    private static void handleGet() {
        String key = getUserInputString("Enter key to get: ");
        String value = cacheManager.get(key);
        System.out.println("Value: " + value);
    }

    private static void handleRemove() {
        String key = getUserInputString("Enter key to remove: ");
        cacheManager.remove(key);
    }

    private static void handleClear() {
        cacheManager.clear();
    }

    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    private static String getUserInputString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
