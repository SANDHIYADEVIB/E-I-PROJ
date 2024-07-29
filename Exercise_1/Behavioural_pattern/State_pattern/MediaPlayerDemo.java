package Behavioural_pattern.State_pattern;

import java.util.Scanner;

/**
 * Demonstrates the use of State pattern for a media player.
 */
public class MediaPlayerDemo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MediaPlayer mediaPlayer = new MediaPlayer();

    public static void main(String[] args) {
        runMediaPlayerDemo();
    }

    private static void runMediaPlayerDemo() {

        String command = getUserInput("Enter your command:play or pause or stop :  ").trim().toLowerCase();

        if ("play".equals(command)) {
            mediaPlayer.play();
        } else if ("pause".equals(command)) {
            mediaPlayer.pause();
        } else if ("stop".equals(command)) {
            mediaPlayer.stop();
            System.out.println("Exiting program.");
            scanner.close();
            return;
        }
        // Exit the recursion
        else {
            System.out.println("Invalid command. Try again.");
        }

        // Recursive call to continue the menu until exit
        runMediaPlayerDemo();
    }

    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
