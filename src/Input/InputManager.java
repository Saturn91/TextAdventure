package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		if(args[0].equals("goTo")){
			if(args[1].equalsIgnoreCase("Nord")){cOutput.goTo(0); return;}
			if(args[1].equalsIgnoreCase("Ost")){cOutput.goTo(1); return;}
			if(args[1].equalsIgnoreCase("Sud")){cOutput.goTo(2); return;}
			if(args[1].equalsIgnoreCase("West")){cOutput.goTo(3); return;}
		}
	}
}
