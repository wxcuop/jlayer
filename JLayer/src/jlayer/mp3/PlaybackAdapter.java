package jlayer.mp3;
 


public class PlaybackAdapter implements PlaybackListener{
	@Override
	public void playbackStarted(PlaybackEvent event){
		System.err.println("Playback started");
	}
	@Override
	public void playbackPaused(PlaybackEvent event){
		System.err.println("Playback paused");
	}
	@Override
	public void playbackFinished(PlaybackEvent event){
		System.err.println("Playback stopped");
	}

}