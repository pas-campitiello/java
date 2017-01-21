import java.awt.BorderLayout;

import javax.swing.*;

public class UnPoDiGrafica 
{
	private static void createAndShowGUI() 
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		createAndShowGUI();
	}
}