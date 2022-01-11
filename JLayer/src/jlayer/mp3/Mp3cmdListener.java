package jlayer.mp3;

class Mp3cmdListener extends PlaybackAdapter {
	// PlaybackListener members
	@Override
	public void playbackStarted(PlaybackEvent playbackEvent){
		System.out.println("PlaybackStarted()");
	}

	@Override
	public void playbackPaused(PlaybackEvent playbackEvent){
		System.out.println("PlaybackPaused()");
	}

	@Override
	public void playbackFinished(PlaybackEvent playbackEvent){
		System.out.println("PlaybackStopped()");
	}
}