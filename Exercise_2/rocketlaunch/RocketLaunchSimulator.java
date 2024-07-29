
import models.Rocket;
import states.PreLaunchState;

import java.util.InputMismatchException;
import java.util.Scanner;

import states.LaunchState;
import states.Logger;

/**
 * RocketLaunchSimulator is the main class that simulates the rocket launch
 * process.
 * It handles user commands and invokes the corresponding state behaviors.
 */
public class RocketLaunchSimulator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Rocket rocket = new Rocket(); // Create a new Rocket instance
        rocket.setState(new PreLaunchState()); // Set initial state to PreLaunchState

        System.out.println("Enter target altitude (in km): ");
        int targetAltitude = getUserInput("Target altitude: ");
        rocket.setTargetAltitude(targetAltitude); // Set target altitude

        runSimulation(rocket); // Start the simulation
        scanner.close(); // Close the scanner
    }

    /**
     * Runs the simulation by processing user commands recursively.
     * The simulation continues until the mission fails or the user exits.
     */
    private static void runSimulation(Rocket rocket) {
        if (rocket.getState() == null || rocket.isMissionFailed()) {
            return; // Exit if no state is set or if mission has failed
        }

        System.out.println("Enter command (start_checks, launch, fast_forward X, exit):");
        String input = scanner.nextLine().trim();

        try {
            if (input.equals("exit")) {
                return; // Terminate the program based on user input
            } else if (input.equals("start_checks")) {
                rocket.getState().handle(rocket); // Handle pre-launch checks
            } else if (input.equals("launch")) {
                rocket.setState(new LaunchState()); // Transition to LaunchState
            } else if (input.startsWith("fast_forward")) {
                String[] parts = input.split(" ");
                if (parts.length == 2) {
                    try {
                        int seconds = Integer.parseInt(parts[1]); // Parse seconds
                        for (int i = 0; i < seconds; i++) {
                            if (rocket.getState() != null && !rocket.isMissionFailed()) {
                                rocket.getState().handle(rocket); // Fast forward simulation
                            }
                        }
                    } catch (NumberFormatException e) {
                        Logger.log("Invalid number of seconds."); // Handle invalid input
                    }
                }
            }
            if (rocket.isMissionFailed()) {
                Logger.log("Mission failed. Terminating simulation.");
                return; // Terminate if mission failed
            }

        } catch (Exception e) {
            Logger.log("An error occurred: " + e.getMessage()); // Handle unexpected exceptions
        }

        runSimulation(rocket); // Recursive call to continue the simulation
    }

    /**
     * Gets an integer input from the user with validation.
     * 
     * @param prompt The prompt message to display to the user.
     * @return The integer input from the user.
     */
    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return scanner.nextInt(); // Return valid input
            } catch (InputMismatchException e) {
                Logger.log("Invalid input. Please enter an integer."); // Handle invalid input
                scanner.next(); // Clear invalid input
                System.out.print(prompt);
            }
        }
    }
}
