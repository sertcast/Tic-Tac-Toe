package buttons;

import dynamics.Button;
import dynamics.Plane;

public class MainMenuButton extends Button {

	public MainMenuButton(int x, int y, int fontSize) {
		super("Main Menu", x, y, fontSize);
	}
	
	public String job(){
		return "Main Menu";
	}
	
	public String clicked(){
		if(mouseIn){
			mouseIn = false;
			return this.job();
		}
		return "";
	}
	public String clicked(Plane p){
		if(mouseIn){
			mouseIn = false;
			p.reset();
			return this.job();
		}
		return "";
	}
}
