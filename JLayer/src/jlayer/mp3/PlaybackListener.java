package jlayer.mp3;

public interface PlaybackListener{
	public void playbackStarted(PlaybackEvent event);
	public void playbackPaused(PlaybackEvent event);
	public void playbackFinished(PlaybackEvent event);
}