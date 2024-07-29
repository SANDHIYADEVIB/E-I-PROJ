package Behavioural_pattern.Interpreter_pattern;

import java.util.Scanner;

/**
 * Demonstrates the use of Interpreter pattern to check if two strings are
 * anagrams.
 */
public class InterpreterDemo {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runInterpreterDemo();
    }

    private static void runInterpreterDemo() {

        // Ask user if they want to check another pair of strings or exit
        System.out.println("to exit enter exit or go");
        String userResponse = scanner.nextLine().trim().toLowerCase();
        // Recursive call to handle another input
        if ("exit".equals(userResponse)) {

            System.out.println("Exiting program.");
            scanner.close();
        } else {
            System.out.println("Enter first string: ");
            String string1 = scanner.nextLine();

            System.out.println("Enter second string: ");
            String string2 = scanner.nextLine();

            Context context = new Context(string1, string2);
            Expression expression = new AnagramExpression();

            boolean result = expression.interpret(context);
            System.out.println("Are the two strings anagrams? " + result);
            runInterpreterDemo();
        }
    }
}
