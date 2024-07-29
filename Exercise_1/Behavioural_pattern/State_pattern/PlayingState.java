package Behavioural_pattern.State_pattern;

public class PlayingState implements MediaPlayerState {

    @Override
    public void play(MediaPlayer mediaPlayer) {
        System.out.println("Already playing.");
    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        System.out.println("Pausing playback.");
        mediaPlayer.setState(new PausedState());
    }

    @Override
    public void stop(MediaPlayer mediaPlayer) {
        System.out.println("Stopping playback.");
        mediaPlayer.setState(new StoppedState());
    }
}
