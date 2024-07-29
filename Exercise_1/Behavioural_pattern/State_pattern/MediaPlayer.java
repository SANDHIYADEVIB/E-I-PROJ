package Behavioural_pattern.State_pattern;

public class MediaPlayer {
    private MediaPlayerState state;

    public MediaPlayer() {
        state = new StoppedState(); // Default state
    }

    public void setState(MediaPlayerState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void pause() {
        state.pause(this);
    }

    public void stop() {
        state.stop(this);
    }
}
