package states;

import models.Rocket;

/**
 * RocketState interface defines the contract for various rocket states.
 * Each state should implement this interface to handle the rocket's behavior.
 */
public interface RocketState {
    void handle(Rocket rocket);
}
