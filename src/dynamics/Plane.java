package dynamics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Plane {
	private Box boxes[][];
	private int x, y, boxWidth, boxCount;
	private boolean oTurn = false;
	private boolean gameOver = false;
	private boolean oWins = false, xWins = false, tie = false;
	private Font font = new Font("Chalkboard", Font.PLAIN, 200);
	private FontMetrics fontMetrics;
	public Plane(int x, int y, int boxWidth){
		this(3, x, y, boxWidth);
	}

	public Plane(int boxCount,int x, int y, int boxWidth){
		this.boxWidth = boxWidth;
		this.x = x;
		this.y = y;
		this.boxCount = boxCount;
		this.boxes = new Box[this.boxCount][this.boxCount];
		for(int i = 0; i < boxes.length; i++){
			for(int j = 0; j < boxes[i].length; j++){
				boxes[i][j] = new Box(j * this.boxWidth + this.x, i * this.boxWidth + this.y, this.boxWidth);
			}	
		}
	}
	public void display(Graphics g){
		for(int i = 0; i < boxes.length; i++){
			for(int j = 0; j < boxes[i].length; j++){
				boxes[i][j].display(g);;
			}	
		}
		g.setColor(Color.black);
		for(int j = 1; j < 5 ; j++){
			for(int i = 1; i < this.boxCount ; i++){
				g.drawLine(x + j + boxWidth * i, y, x + j+ boxWidth * i, y+ boxWidth * boxCount);
				g.drawLine(x, y+ j + boxWidth * i, x + boxWidth * boxCount, y + j + boxWidth * i);
			}
		}
		if(gameOver){
			g.setFont(font);
			int resultX, resultY;
			g.setColor(new Color(255,255,255,200));
			fontMetrics = g.getFontMetrics(font);
			resultY = 300 + fontMetrics.getHeight() / 2;
			if (xWins) {
				resultX = 375 - fontMetrics.stringWidth("X WINS")/2;
				g.drawString("X WINS", resultX, resultY);
			}else if(oWins){
				resultX = 375 - fontMetrics.stringWidth("O WINS")/2;
				g.drawString("O WINS", resultX, resultY);
			}else if(tie){
				resultX = 375 - fontMetrics.stringWidth("TIE")/2;
				g.drawString("TIE", resultX, resultY);
			}
		}
	}
	public void clicked(MouseEvent e){
		if(!gameOver){
			boolean mouseOn = false;
			for(int i = 0; i < boxes.length; i++){
				for(int j = 0; j < boxes[i].length; j++){
					mouseOn = boxes[i][j].mouseOn(e);
					if(oTurn && mouseOn){
						boxes[i][j].setDisp('o');
						oTurn = !oTurn;
						break;
					}else if(mouseOn){
						boxes[i][j].setDisp('x');
						oTurn = !oTurn;
						break;
					}
				}
				if(mouseOn) break;
			}
			this.winCheck();
		}
	}
	public void reset(){
		for(int i = 0; i < boxes.length; i++){
			for(int j = 0; j < boxes[i].length; j++){
				boxes[i][j].reset();
			}	
		}
		oWins = false;
		xWins = false;
		tie = false;
		gameOver = false;
	}
	public void winCheck(){
		char win = ' ';
		for(int i = 0; i < 3; i++){
			win = check(i);
			if(win == 'o'){
				gameOver = true;
				oWins = true;
				return;
			}
			else if(win == 'x'){
				gameOver = true;
				xWins = true;
				return;
			}
		} 
		if(tieCheck()){
			tie = true;
			gameOver = true;
			return;
		}
	}
	private char horizontalCheck(){
		int counter = 0;
		char keeper = ' ';
		for(int i = 0; i < boxes.length; i++){
			for(int j = 0; j < boxes[i].length - 1; j++){
				if(boxes[i][j].getDisp() == boxes[i][j+1].getDisp() && boxes[i][j].getDisp() != ' '){
					counter++;
					keeper = boxes[i][j].getDisp();
				}
				if(counter == 2){
					return keeper;
				}
			}
			counter = 0;
		}
		return ' ';
	}
	private char verticalCheck(){
		int counter = 0;
		char keeper = ' ';
		for(int i = 0; i < boxes.length; i++){
			for(int j = 0; j < boxes[i].length-1; j++){
				if(boxes[j][i].getDisp() == boxes[j+1][i].getDisp() && boxes[j][i].getDisp() != ' '){
					counter++;
					keeper = boxes[j][i].getDisp();
				}
				if(counter == 2){
					return keeper;
				}
			}
			counter = 0;
		}
		return ' ';
	}
	private boolean tieCheck(){
		for(int i = 0; i < boxes.length; i++){
			for(int j = 0; j < boxes[i].length; j++){
				if(boxes[i][j].getDisp() == ' ')return false;
			}
		}
		return true;
	}
	public char diagCheck(){
		
		int counter = 0;
		char keeper = ' ';
		for(int h = 0; h < boxes.length-2; h++){
			for(int i = boxes.length - 3; i >= 0;i--){
				for(int j = 0; j < 2; j++){
					if(boxes[j +h][j +i].getDisp()==boxes[j+1 +h][j+1 +i].getDisp() && boxes[j +h][j +i].getDisp() != ' '){
						counter++;
						keeper = boxes[j +h][j +i].getDisp(); 
					}
					if(counter == 2)return keeper;
				}
				counter = 0;
			}
			counter = 0;
		}
		for(int h = boxes.length - 1; h >= 2;h--){
			for(int i = 0; i < boxes.length-2;i++){
				for(int j = 0; j < 2; j++){
					if(boxes[-j +h][j +i].getDisp()==boxes[-j-1 +h][j+1 +i].getDisp() && boxes[-j +h][j +i].getDisp() != ' '){
						counter++;
						keeper = boxes[-j +h][j +i].getDisp(); 
					}
					if(counter == 2)return keeper;
				}
				counter = 0;
			}
			counter = 0;
		}
		return ' ';
	}
	public char check(int n){
		switch(n){
		case 0:
			return diagCheck();
		case 1:
			return horizontalCheck();
		default:
			return verticalCheck();
		}
	}
}
