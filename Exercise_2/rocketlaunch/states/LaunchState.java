package states;

import models.Rocket;

/**
 * LaunchState represents the state when the rocket is in the launch phase.
 * It updates the rocket's status every second and checks for mission failure.
 */
public class LaunchState implements RocketState {
    @Override
    public void handle(Rocket rocket) {
        if (rocket.getFuel() <= 0) {
            rocket.setMissionFailed(true);
            Logger.log("Mission Failed due to insufficient fuel.");
            return;
        }

        // Simulate the rocket's progress
        rocket.setFuel(rocket.getFuel() - 10); // Example: Decrease fuel
        rocket.setAltitude(rocket.getAltitude() + 100); // Example: Increase altitude
        rocket.setSpeed(rocket.getSpeed() + 100); // Example: Increase speed

        if (rocket.getAltitude() >= rocket.getTargetAltitude()) {
            Logger.log("Orbit achieved! Mission Successful.");
            return;
        }

        Logger.log("Each second of flight: " + rocket);
    }
}
