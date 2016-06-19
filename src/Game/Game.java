package Game;

import Main.Main;
import StoryController.StoryController;

public class Game {
	private StoryController storyController;
	
	public Game() {
		storyController = new StoryController("./res/Story.story");
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
