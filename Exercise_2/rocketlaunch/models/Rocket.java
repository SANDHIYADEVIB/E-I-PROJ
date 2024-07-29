package models;

import states.RocketState;

/**
 * The Rocket class represents the state and attributes of the rocket.
 * It maintains the current state, fuel level, altitude, speed, stage, and
 * target altitude.
 */
public class Rocket {
    private RocketState state; // Current state of the rocket (State Pattern)
    private int fuel = 100; // Fuel level
    private int altitude = 0; // Altitude
    private int speed = 0; // Speed
    private int stage = 1; // Current stage
    private int targetAltitude = 100; // Target altitude for orbit
    private boolean missionFailed = false; // Flag indicating mission failure

    // Getters and setters
    public RocketState getState() {
        return state;
    }

    public void setState(RocketState state) {
        this.state = state;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getTargetAltitude() {
        return targetAltitude;
    }

    public void setTargetAltitude(int targetAltitude) {
        this.targetAltitude = targetAltitude;
    }

    public boolean isMissionFailed() {
        return missionFailed;
    }

    public void setMissionFailed(boolean missionFailed) {
        this.missionFailed = missionFailed;
    }

    @Override
    public String toString() {
        return String.format("Stage: %d, Fuel: %d%%, Altitude: %d km, Speed: %d km/h",
                stage, fuel, altitude, speed);
    }
}
