package Output;

import StoryController.StoryController;

public class ConsoleOutput {
	private boolean inDialog = false;
	private static final int lineLenght = 75;
	private StoryController storyController;
	
	public ConsoleOutput(StoryController storyController) {
		this.storyController = storyController;
	}
	
	public void print(){
		if(inDialog){
			printDialog();
		}else{
			printRoom();
		}
	}

	private void printRoom() {
		//**************RoomName******************
		System.out.println();
		printLine();
		printTitel(storyController.getRoomName());
		printLine();
		
		//*************Description****************
		System.out.println();
		printText(storyController.getRoomDescription());
		System.out.println();
		
		//*****************Exits********************
		printExits();
	}
	
	private void printExits(){
		String[] exits = storyController.getRoomExits();
		int exitCounter = 0;
		for(int i = 0; i< exits.length; i++){
			if(exits[i]!= null){
				exitCounter++;
			}
		}
		printTitel("There is/are " + exitCounter + " visuable exits");
		System.out.println();
		for(int i = 0; i < exits.length; i++){
			if(exits[i] != null){
				printTitel(getDirection(i) + ": " + exits[i]);
			}			
		}
		printLine();
	}
	
	private String getDirection(int direction){
		switch(direction){
			case 0:
				return "North";
			case 1:
				return "East";
			case 2: 
				return "South";
			case 3:
				return "West";
			default:
				System.err.println("ConsoleOutput: wrong argument <" + direction + "> must be between 0 and 3!");
				return null;
		}
	}

	private void printDialog() {
		
		
	}
	
	private void printLine(){
		for(int i = 0; i < lineLenght; i++){
			System.out.print("=");
		}
		System.out.println();
	}
	
	private void printTitel(String line){
		if(line.length() > lineLenght){
			String[] lines = getMultipleLines(line);
			for(int i = 0; i < lines.length-1; i++){
				System.out.println(lines[i]);
			}
			printTitel(lines[lines.length-1]);
		}else{
			for(int i = 0; i < (lineLenght - line.length())/2; i++){
				System.out.print(" ");
			}
			System.out.println(line);
		}
	}
	
	private void printText(String text){
		if(text.length()>lineLenght){
			String[] lines = getMultipleLines(text);
			for(int i = 0; i < lines.length; i++){
				System.out.println(lines[i]);
			}
		}else{
			System.out.println(text);
		}
	}
	
	private String[] getMultipleLines(String lines){
		int lineNumber = (lines.length()/lineLenght) + 1;
		String output[] = new String[lineNumber];
		int cursor = 0;
		for(int i = 0; i < lineNumber; i++){
			if(cursor+lineLenght > lines.length()){
				cursor = lines.length()-1;
			}else{
				cursor += lineLenght;
			}
			output[i] = lines.substring(i*lineLenght, cursor);
		}
		return output;
	}
	
	public void goTo(int direction){
		storyController.goTo(direction);
	}
	
	
}
