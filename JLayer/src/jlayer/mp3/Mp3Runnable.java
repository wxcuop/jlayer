package jlayer.mp3;

import javazoom.jl.decoder.JavaLayerException;

class Mp3Runnable implements Runnable{
	private String filePath;
	private MP3Player player;
	private Thread playerThread;
	private String namePlayerThread = "Mp3Runnable Thread";
	private PlaybackListener playbackListener = new Mp3cmdListener();

	public Mp3Runnable(String filePath){
		this.filePath = filePath;
	}

	public Mp3Runnable(String filePath, String namePlayerThread){
		this.filePath = filePath;
		this.namePlayerThread = namePlayerThread;
	}

	public void play(){
		if (this.player == null){
			this.playerInitialize();
		}
		else if(!this.player.isPaused() || this.player.isComplete() || this.player.isStopped()){
			this.stop();
			this.playerInitialize();
		}
		this.playerThread = new Thread(this, namePlayerThread);
		this.playerThread.setDaemon(true);

		this.playerThread.start();
	}

	public void pause(){
		if (this.player != null){
			this.player.pause();


			if(this.playerThread != null){
				this.playerThread = null;
			}
		}
	}

	public void pauseToggle(){
		if (this.player != null){
			if (this.player.isPaused() && !this.player.isStopped()){
				this.play();
			}
			else{
				this.pause();
			}
		}
	}
	
	public void volUp() {
		
	}

	public void stop(){
		if (this.player != null){
			this.player.stop();

			if(this.playerThread != null){
				this.playerThread = null;
			}
		}
	}
	private void playerInitialize(){
		try {
			this.player = new MP3Player(this.filePath);
			this.player.setPlaybackListener(this.playbackListener);
		}
		catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}

	public void run(){
		try{
			this.player.resume();
		}
		catch (javazoom.jl.decoder.JavaLayerException ex){
			ex.printStackTrace();
		}
	}




}