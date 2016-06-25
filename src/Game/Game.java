package Game;

import Input.InputManager;
import Main.Main;
import Output.ConsoleOutput;
import StoryController.StoryController;

public class Game {
	private StoryController storyController;
	private InputManager inputManager;
	private ConsoleOutput cOutput;
	private boolean isFirst = true;

	public Game() {
		storyController = new StoryController("./res/Story", ConsoleOutput.player);
		cOutput = new ConsoleOutput(storyController);
		inputManager = new InputManager(cOutput);
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

	public void tick(){
		storyController.tick();
		if(!isFirst){
			inputManager.getNextInput();
		}else{
			isFirst = false;
		}
		cOutput.print();
	}

	public void close() {
		System.out.println("Closing game!");
	}

}
