package Game;

import Main.Main;

public class Game {
	public Game() {
		
	}
	
	private int counter = 0;
	public void tick(){
		counter++;
		System.out.println("yep");
		if(counter >= 10){
			Main.running = false;
		}
	}
	
	public void close(){
		System.out.println("Closing game!");
	}

}
