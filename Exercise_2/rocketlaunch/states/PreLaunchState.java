package states;

import models.Rocket;

/**
 * PreLaunchState represents the state before the rocket is launched.
 * It handles the pre-launch checks and transitions to the launch state.
 */
public class PreLaunchState implements RocketState {
    @Override
    public void handle(Rocket rocket) {
        Logger.log("Pre-Launch Checks: All systems are 'Go' for launch.");
        rocket.setState(new LaunchState()); // Transition to LaunchState
    }
}
