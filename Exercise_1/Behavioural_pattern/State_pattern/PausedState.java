package Behavioural_pattern.State_pattern;

public class PausedState implements MediaPlayerState {

    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Resuming playback.");
        mediaPlayer.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Already paused.");
    }

    @Override
    public void stop(MediaPlayer mediaPlayer) {
        System.out.println("Stopping playback from pause.");
        mediaPlayer.setState(new StoppedState());
    }
}
