package jlayer.mp3;
import java.util.Scanner;

public class Mp3cmd {
	private Mp3Runnable song;

	public static void main(String[] args)
	{
		Mp3cmd mp3player = new Mp3cmd();
		if (args.length != 1)
		{
			mp3player.showUsage();
			System.exit(0);
		}
		else
		{
			try
			{
				mp3player.song = new Mp3Runnable(args[0]);
			}
			catch (Exception ex)
			{
				System.err.println(ex.getMessage());
				System.exit(0);
			}
			Scanner command = new Scanner(System.in);
			System.out.println("Enter command: ");
			boolean running = true;

			while(running){

				switch(command.nextLine()){

				case "play":
					mp3player.song.play();	
					break;

				case "pause":
					mp3player.song.pauseToggle();
					break;

				case "stop":
					mp3player.song.stop();
					break;

				case "exit":
					mp3player.song.stop();;
					System.out.println("Application Closed");
					running = false;
					break;

				default:
					System.out.println("Command not recognized!");
					break;
				}
			}
			command.close();
		}

	}

	public void showUsage()
	{
		System.out.println("Usage: Mp3cmd <filename>");
		System.out.println("");
		System.out.println(" e.g. : java jlayer.mp3.Mp3cmd localfile.mp3");
	}

}	



