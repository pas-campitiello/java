import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame 
{
	private Application owner; // Loopback
	private JTextField baseValue;  // Unico componente che deve essere raggiungibile da un 
								   // metodo pubblico. Gli altri componenti sono tutti 
								   // dichiarati nel metodo setup()
	
	public MainFrame(Application application) 
	{
		super("Math application");
		setup();
		owner = application;
	}

	public void showBase(int base) 
	{
		baseValue.setText("base: "+base);
	}
	
	private void setup() 
	{
		// Top panel to set the base number
		baseValue = new JTextField("Base not set.", 20);
		JButton set = new JButton("set");
		
		set.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				owner.setBase(Integer.parseInt(baseValue.getText()));
			}
		});
		
		JPanel topPane = new JPanel();//FlowLayout by default
		topPane.add(baseValue);
		topPane.add(set);

		// panel1: sum the input field value to the base number
		JButton sum = new JButton("sum");
		final JTextField input = new JTextField(10);
		final JLabel result = new JLabel("Your results here...");
		result.setBorder(BorderFactory.createTitledBorder("Result"));
		
		sum.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int x = Integer.parseInt(input.getText());
				result.setText(x+" + the base equals "+owner.sum(x));
			} 
		});
		
		GridBagLayout gbl = new GridBagLayout(); //The most flexible layout manager
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel1 = new JPanel(gbl);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2, 4, 2, 4);
		gbl.setConstraints(input, gbc); //gbc is cloned
		panel1.add(input);
		gbc.gridx++;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbl.setConstraints(sum, gbc);
		panel1.add(sum);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 4, 10, 4);
		gbl.setConstraints(result, gbc);
		panel1.add(result);
		
		// panel2: perform all operations on numbers between min and max
		JPanel panel2 = new JPanel(new BorderLayout());
		JLabel minLabel = new JLabel("min");
		final JTextField min = new JTextField(10);
		JLabel maxLabel = new JLabel("max");
		final JTextField max = new JTextField(10);
		final JTable table = new JTable();
		final JPanel panel2_main = new JPanel();
		JButton go = new JButton("go");
		go.setToolTipText("<HTML>Click <em>here</em> to perform<br /> " +
				"operations on the given <strong>sequence</strong></HTML>");
		go.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int m = Integer.parseInt(min.getText());
				int M = Integer.parseInt(max.getText());
				Double[][] data = owner.performOperations(m, M);
				panel2_main.removeAll();
				JTable t = new JTable(data, owner.getOperations());
				// stupid table! Use TableModel for advanced options
				panel2_main.add(new JScrollPane(t)); //JScrollPane wraps the table
				validate(); //refresh contents to show the new table
			} 
		});
		
		JPanel panel2_top = new JPanel();
		panel2_top.add(minLabel);
		panel2_top.add(min);
		panel2_top.add(maxLabel);
		panel2_top.add(max);
		panel2_top.add(go);
		panel2_main.setBackground(Color.YELLOW);
		panel2_main.setPreferredSize(new Dimension(500, 500));
		panel2_main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(panel2_top, BorderLayout.NORTH);
		panel2.add(panel2_main, BorderLayout.CENTER);
		panel2.setBorder(BorderFactory.createTitledBorder("Many Operations"));
		JTabbedPane tabs = new JTabbedPane();
		tabs.add("sum", panel1);
		tabs.add("all", panel2);
		JPanel cp = new JPanel(new BorderLayout());
		cp.add(topPane, BorderLayout.NORTH);
		cp.add(tabs, BorderLayout.CENTER);
		setContentPane(cp);
		pack(); //set components' dimensions
	}
}
