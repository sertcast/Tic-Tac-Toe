package dynamics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener  {
	private Timer tm = new Timer(100, this);
	private Button button = new Button("HelloIgy", 375,375 ,25);
	private int keep = button.getKeep();
	public Display() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(170, 203, 255));
		button.display(g);
		g.setColor(Color.BLACK);
		g.drawString("" + keep, 100, 100);
		this.tm.start();
	}
	public void actionPerformed(ActionEvent event) {
		keep = button.getKeep();
		this.repaint();
	}
	/********MOUSEMOTIONLISTENER*******/ 
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		button.mouseMoved(e);
	}
	
	/********MOUSELISTENER*******/
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		button.mousePressed(e);
	}
	public void mouseReleased(MouseEvent e) {}
	
	/********KEYLISTENER*******/
	public void keyPressed(KeyEvent e) {
		button.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
