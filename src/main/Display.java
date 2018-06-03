package main;

import java.awt.Color;
import java.awt.Font;
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

import buttons.InstructionsButton;
import buttons.MainMenuButton;
import buttons.StartGameButton;
import dynamics.Plane;

public class Display extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	
	private Timer tm = new Timer(50, this);
	private MainMenuButton mainMenu = new MainMenuButton(375,650 ,25);
	private StartGameButton startGame = new StartGameButton(375,500 ,25);
	private InstructionsButton instructions = new InstructionsButton(375,575 ,25);
	private String scene = "Main Menu";
	private Font font = new Font("Chalkboard", Font.PLAIN, 96);
	
	private int frameW, frameH, boxSize, boxCount = 10;
	private int boardX, boardY;
	private Plane board;
	
	
	public Display(int w, int h) {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);

		this.frameW = w;
		this.frameH = h;
		this.boxSize = (w-175) / boxCount;
		this.boardX = frameW / 2 - (boxSize * boxCount) / 2;
		this.boardY = frameH / 2 - (boxSize * boxCount) / 2 - 60;
		board = new Plane(boxCount, boardX, boardY, boxSize);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(170, 203, 255));
		
		if(scene.equals("Main Menu")){
			g.setFont(font);
			int titleX = 375 - this.getFontMetrics(font).stringWidth("TIC TAC TOE") / 2;
			int titleY = 375 - this.getFontMetrics(font).getHeight() / 2;
			g.setColor(new Color(255, 50,50));
			g.drawString("TIC TAC TOE", titleX, titleY);
			
			startGame.display(g);
			instructions.display(g);
		}else if(scene.equals("Instructions")){
			mainMenu.display(g);
			
		}else if(scene.equals("Start Game")){
			board.display(g);
			mainMenu.display(g);
		}
		g.setFont(new Font("Chalkboard", Font.BOLD, 30));
		g.setColor(Color.black);
		this.tm.start();
	}
	public void actionPerformed(ActionEvent event) {
		repaint();
	}
	
	/********MOUSEMOTIONLISTENER*******/ 
	public void mouseMoved(MouseEvent e) {
		if(scene.equals("Main Menu")){
			startGame.mouseOver(e);
			instructions.mouseOver(e);
		}else if(scene.equals("Instructions")){
			mainMenu.mouseOver(e);
		}else if(scene.equals("Start Game")){
			mainMenu.mouseOver(e);
		}
	}
	public void mouseDragged(MouseEvent e) {}
	
	/********MOUSELISTENER*******/
	public void mousePressed(MouseEvent e) {
		String check;
		if(scene.equals("Main Menu")){
			check = startGame.clicked();
			if(!check.equals("")){
				scene = check;
				return;
			}
			check = instructions.clicked();
			if(!check.equals("")){
				scene = check;
				return;
			}
		}else if(scene.equals("Instructions")){
			check = mainMenu.clicked();
			if(!check.equals("")){
				scene = check;
				return;
			}
		}else if(scene.equals("Start Game")){
			board.clicked(e);
			check = mainMenu.clicked(board);
			if(!check.equals("")){
				scene = check;
				return;
			}
		}
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	/********KEYLISTENER*******/
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'r'){
			this.board.reset();
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}