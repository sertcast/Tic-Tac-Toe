package buttons;

import dynamics.Button;

public class StartGameButton extends Button {

	public StartGameButton(int x, int y, int fontSize) {
		super("Start Game", x, y, fontSize);
	}
	
	
	public String job(){
		return "Start Game";
	}
	
	public String clicked(){
		if(mouseIn)	{
			mouseIn = false;
			return this.job();
		}
		return "";
	}
}
