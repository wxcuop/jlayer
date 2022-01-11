package jlayer.mp3;

public class PlaybackEvent{    
	public MP3Player source;
	public EventType eventType;
	public int frameIndex;
	
	public PlaybackEvent(MP3Player source, EventType eventType, int frameIndex)        {
		this.source = source;
		this.eventType = eventType;
		this.frameIndex = frameIndex;
	}

}