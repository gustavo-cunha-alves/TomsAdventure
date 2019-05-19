package game;



import java.io.InputStream;

import javazoom.jl.player.Player;

public class Musica extends Thread{
	Player ply;
	
	public Musica(){
		start();
	}
	
	@Override
	public void run(){
		try {
			InputStream input = this.getClass().getResourceAsStream("../music/musica.mp3");
			ply = new Player(input);
			ply.play();
			while(ply.isComplete()){
				ply.play();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
