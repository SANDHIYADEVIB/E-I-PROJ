package Behavioural_pattern.State_pattern;

public class StoppedState implements MediaPlayerState {

    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Starting playback.");
        mediaPlayer.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Cannot pause. Media player is stopped.");
    }

    @Override
    public void stop(MediaPlayer mediaPlayer) {
        System.out.println("Already stopped.");
    }
}
