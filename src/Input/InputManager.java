package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Entity.Main.EntityManager;
import Output.ConsoleOutput;
import StoryController.StoryController;

public class InputManager {
	private ConsoleOutput cOutput;
	private String args[] = {"..."};
	private final String empty[] = {"..."};
	
	public InputManager(ConsoleOutput cOutput) {
		this.cOutput = cOutput;
	}
	
	public void getNextInput(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = null;
        boolean firstTurn = true;
        while(!isvaluableCommand(args[0])){
        	if(!firstTurn){
        		System.out.println("wrong Command!");
        	}
        	try {
    			inputText = br.readLine();
    		} catch (IOException e) {
    			System.err.println("InputManager: Error while reading inputLine");
    			e.printStackTrace();
    		}
    		firstTurn = false;
    		args = inputText.split(" ");
        }		
        HandleOutput();
		args = empty;
	}
	
	private boolean isvaluableCommand(String cmd){
		if(cmd == null){
			return false;
		}
		Commands[] test = Commands.values();
		for(Commands c: test){
			if(cmd.equalsIgnoreCase(c.toString())){
				return true;
			}
		}
		return false;
	}
	
	private void HandleOutput(){
		//Switchcase not possible because of ignorecase
		if(args[0].equalsIgnoreCase("go")){
			if(args[1].equalsIgnoreCase("North")){cOutput.getStoryController().goTo(0); return;}
			if(args[1].equalsIgnoreCase("East")){cOutput.getStoryController().goTo(1); return;}
			if(args[1].equalsIgnoreCase("South")){cOutput.getStoryController().goTo(2); return;}
			if(args[1].equalsIgnoreCase("West")){cOutput.getStoryController().goTo(3); return;}
		}
		
		if(args[0].equalsIgnoreCase("take")){
			if(cOutput.getStoryController().takeFromRoomInventory(args[1])){
				EntityManager.getEntity(ConsoleOutput.player).addToInventory(args[1]);
				System.out.println("taken!");
			}else{
				System.out.println("you can't see " + args[1]);
			}
		}
		
		if(args[0].equalsIgnoreCase("talk")){
			cOutput.getStoryController().openDialog(args[1]);
		}
	}
}
