package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import dynamics.Display;

public class MainClass {
	private static JFrame window;
	private static JLabel label;
	private static Display disp;
	public static void main(String[] args) {
		window = new JFrame("Tic Tac Toe");
		disp = new Display();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(750,750);
		window.add(disp);
		window.setResizable(false);
		window.setVisible(true);
		
	}

}
