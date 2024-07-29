package Creational_pattern.Factory_pattern;

import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Burger Shop!");
        System.out.print("Enter the type of burger (veggie, cheese, chicken) or type 'exit' to quit: ");
        String type = scanner.nextLine().trim();

        while (!type.equalsIgnoreCase("exit")) {
            try {
                Burger burger = BurgerFactory.createBurger(type);
                burger.prepare();
                burger.cook();
                burger.box();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("\nEnter the type of burger (veggie, cheese, chicken) or type 'exit' to quit: ");
            type = scanner.nextLine().trim();
        }

        System.out.println("Thank you for visiting the Burger Shop!");
        scanner.close();
    }
}
