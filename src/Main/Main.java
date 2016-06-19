package Main;

import Game.Game;

public class Main {
	
	public static boolean running = true;

	public static void main(String[] args) {
		Game game = new Game();
		while(running){
			game.tick();
		}
		
		game.close();
	}

}
