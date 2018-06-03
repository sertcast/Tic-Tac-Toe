package main;

import javax.swing.JFrame;

public class MainClass {
	private static JFrame window;
	private static Display disp;
	public static void main(String[] args) {
		window = new JFrame("Tic Tac Toe");
		window.setSize(750,750);
		disp = new Display(750, 750);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(disp);
		window.setResizable(false);
		window.setVisible(true);
		
	}

}