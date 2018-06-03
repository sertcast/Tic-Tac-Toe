package buttons;

import dynamics.Button;

public class InstructionsButton extends Button {

	public InstructionsButton(int x, int y, int fontSize) {
		super("Instructions", x, y, fontSize);
	}
	public String job(){
		return "Instructions";
	}
	public String clicked(){
		if(mouseIn){
			mouseIn = false;
			return this.job();
		}
		return "";
	}

}
