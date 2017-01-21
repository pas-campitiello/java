import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class colore 
{
	public static void main(String[] args) 
	{
		JFrame frameprova=new JFrame("CIAO");
		
		JPanel pan1 =new JPanel();
		pan1.setLayout(new BorderLayout());
		pan1.setBorder(BorderFactory.createLineBorder(Color.black));
		//pan1.setBackground(Color.RED);
		
		JPanel pan2 = new JPanel();
		pan2.setBorder(BorderFactory.createLineBorder(Color.black));

		frameprova.getContentPane().add(BorderLayout.NORTH,pan1);
		pan1.setBackground(Color.red);
		frameprova.getContentPane().add(BorderLayout.SOUTH,pan2);
		pan2.setBackground(Color.blue);
		
		JLabel lab1 = new JLabel(" LABEL 1");
		lab1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel lab2 = new JLabel(" LABEL 2");
		lab2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		pan1.add(BorderLayout.NORTH,lab1);
		pan1.add(BorderLayout.SOUTH,lab2);
		
		lab1.getRootPane().setBackground(Color.yellow);
		
		frameprova.setSize(300,300);
		frameprova.getContentPane().setBackground(Color.green);
		frameprova.setVisible(true);
		
	}

}
