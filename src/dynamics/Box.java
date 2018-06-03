package dynamics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Box {
	private int x, y, size;
	private char disp = ' ';
	private boolean setValue = false;
	public Box(int x, int y, int size){
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public void display(Graphics g){
		if(this.disp == 'o'){
			this.drawO(g);
		}else if(this.disp == 'x'){
			this.drawX(g);
		}

	}
	public void drawO(Graphics g){
		g.setColor(Color.BLUE);
		for(int i = 0; i < size/10; i++){
			g.drawOval(x + size/10 + i, y + size/10 + i, size*4/5 - i*2, size*4/5 - i*2);
		}
	}
	public void drawX(Graphics g){
		g.setColor(Color.RED);
		for(int i = 0; i <= size/10; i++){
			g.drawLine(x + size/10, y + size/10 + i, x + size*9/10, y + (size*9/10) + i);
		}
		for(int i = size/10; i >= 0; i--){
			g.drawLine(x + size/10,  y + (size*9/10)+ i, x + (size*9/10), y + size/10 + i);
		}
	}
	public boolean mouseOn(MouseEvent e){
		int mouseX = e.getX();
		int mouseY = e.getY();
		if(mouseX > x && mouseX < x+size && mouseY > y && mouseY < y+size&&!this.setValue){
			return true;
		}
		return false;
	}
	public void setDisp(char disp){
		if(!this.setValue){
			this.disp = disp;
			this.setValue =true;
		}
	}
	public char getDisp(){
		return this.disp;
	}
	public void reset(){
		this.setValue = false;
		this.disp = ' ';
	}
}
