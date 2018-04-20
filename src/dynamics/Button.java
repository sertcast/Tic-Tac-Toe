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

public class Button extends JPanel implements ActionListener{

	private int xPos, yPos, width, height, fontSize, txtXpos, txtYpos, roundSize;
	private String txt;
	private Color colour;
	private Font font;
	private boolean mouseIn;
	public Button(String txt, int x, int y, int fontSize) {
		this.colour = Color.ORANGE;
		
		this.txt = txt;
		this.fontSize = fontSize;
		this.font = new Font("Chalkboard", Font.PLAIN, 40);
		
		this.width = this.getFontMetrics(this.font).stringWidth(txt);
		this.height = this.getFontMetrics(this.font).getHeight();
		this.roundSize = this.width / 5;
		
		this.xPos = x - this.roundSize / 2;
		this.yPos = y - this.height / 2 + this.getFontMetrics(this.font).getDescent();
		
		this.txtXpos = x;
		this.txtYpos = y + this.height / 2;
	}
	public void display(Graphics g) {
		super.paintComponent(g);
		g.setFont(this.font);
		g.setColor(colour);
		g.fillRoundRect(xPos, yPos, width + roundSize, height, roundSize, height);
		g.setColor(Color.WHITE);
		g.drawString(txt, txtXpos, txtYpos);
		
	}
	
	
	/********MOUSEMOTIONLISTENER*******/ 
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		boolean isMouseXIn = e.getX() > this.xPos && e.getX() < this.xPos + this.width + this.roundSize;
		boolean isMouseYIn = e.getY() > this.yPos && e.getX() < this.yPos + this.height;
		if(isMouseXIn && isMouseYIn) {
			
		}
	}
	
	/********MOUSELISTENER*******/
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	/********ACTIONLISTENER*******/
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	/********KEYLISTENER*******/
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	

}