package dynamics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Button extends JPanel{

	protected int xPos, yPos, width, height, fontSize, txtXpos, txtYpos, roundSize,x ,y;
	protected String txt;
	protected Color colour, txtColour;
	protected Font font;
	protected boolean mouseIn = false;
	public Button(String txt, int x, int y, int fontSize) {
		this.colour = Color.ORANGE;
		this.txtColour = Color.WHITE;
		
		this.x = x;
		this.y = y;
		this.txt = txt;
		this.fontSize = fontSize;
		this.font = new Font("Comic Sans MS", Font.PLAIN, 40);
		
		this.width = this.getFontMetrics(this.font).stringWidth(txt);
		this.height = this.getFontMetrics(this.font).getHeight();
		this.roundSize = this.width / 5;
		
		this.xPos = (x - this.roundSize / 2) - (width / 2);
		this.yPos = y - this.height / 2;
		
		this.txtXpos = x - this.width / 2;
		this.txtYpos = y + this.height /2 - this.getFontMetrics(font).getDescent();
	}
	public void display(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(this.font);
		g.setColor(colour);
		g.fillRoundRect(xPos, yPos, width + roundSize, height, roundSize, height);

		g.setColor(txtColour);
		g.drawString(txt, txtXpos, txtYpos);
		if(this.mouseIn) {
			g.setColor(Color.black);
			g.drawRoundRect(xPos, yPos, width + roundSize, height, roundSize, height);		
		}
	}
	public void display(int x, int y, Graphics g) {
		super.paintComponent(g);
		
		g.setFont(this.font);
		g.setColor(colour);
		g.fillRoundRect(xPos, yPos, width + roundSize, height, roundSize, height);

		g.setColor(txtColour);
		g.drawString(txt, txtXpos, txtYpos);
		if(this.mouseIn) {
			g.setColor(Color.black);
			g.drawRoundRect(xPos, yPos, width + roundSize, height, roundSize, height);		
		}
	}
	

	public void mouseOver(MouseEvent e) {
	
		boolean isMouseXIn = e.getX() > this.x  - (this.width / 2 + this.roundSize / 2)&& e.getX() < this.x + (this.width / 2 + this.roundSize / 2);
		boolean isMouseYIn = e.getY() > this.y - this.height / 2 && e.getY() < this.y + this.height / 2;
		if(isMouseXIn && isMouseYIn) {
			this.mouseIn = true;
		}else {
			this.mouseIn = false;
		}
		
	}
	
	/********ACTIONLISTENER*******/
	

}