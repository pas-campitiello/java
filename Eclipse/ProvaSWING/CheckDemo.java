import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckDemo 
{
	private JFrame jframe = new JFrame("Example");
	private JCheckBox jck1;
	private JCheckBox jck2;
	private JCheckBox jck3;
	private JCheckBox jck4;
	
	public CheckDemo() 
	{
		setupjframe();
		componentsSetup();
		jframe.setVisible(true);
	}
	
	private void setupjframe() 
	{
		jframe.setSize(400,100);
		jframe.getContentPane().setLayout( new FlowLayout() );
		//WindowListener l = new MyWindowAdapter();
		//jframe.addWindowListener(l);
	}

	private void componentsSetup() 
	{
		jck1 = new JCheckBox("Pepperoni");
		jck2 = new JCheckBox("Mushroom");
		jck3 = new JCheckBox("Black olives");
		jck4 = new JCheckBox("Tomato");
		//jck1.addActionListener(new MyActionListener());
		//jck2.addItemListener(new MyItemListener());
		Container c = jframe.getContentPane();
		c.add(jck1);
		c.add(jck2);
		c.add(jck3);
		c.add(jck4);
		jframe.pack();
		jck1.addActionListener(new MyActionListener());
		jck2.addActionListener(new MyActionListener());
		jck3.addActionListener(new MyActionListener());
		jck4.addActionListener(new MyActionListener());
	}
	
	public static void main(String[] args) 
	{
		new CheckDemo();
	}
	
	public class MyActionListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{ 
			System.out.println("event = " + e + "\n hai cliccato\n"); 
		}
	}
	
	public class MyItemListener implements ItemListener 
	{
		public void itemStateChanged(ItemEvent e) 
		{
			if (e.getStateChange()==e.SELECTED)
				System.out.print("selected ");
			else System.out.print("de-selected ");
				System.out.print("Mushroom\n");
		}
	}
}