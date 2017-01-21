import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Bottone extends Frame
{
	// Costruttore classe Bottone
	
	Button cliccami = new Button("Cliccami");
	Label cliccato = new Label("Non mi hai cliccato nemmeno una volta");
	
	public Bottone()
	{
		cliccami.addActionListener(new Ascoltatore());
		
		// setup comando
		
		cliccami.setActionCommand("CLICK");
		
// Aggiungo il bottone e la label al Frame.
// Non badate alle seguenti istruzioni,
// la add serve ad aggiungere un componente ad
// un contenitore, e il secondo parametro della
// add, ovvero borderLayout, è un gestore di Layout,
// che serve a stabilire il modo in cui gli oggetti
// GUI vengono posti nel contenitore.
		
		add(cliccami,BorderLayout.NORTH);
		add(cliccato,BorderLayout.SOUTH);
		
		// metodi di Frame
		pack();
		setVisible(true);
}
	
// main
public static void main (String [] arg)
{
	new Bottone();
}

// Ascoltatore di eventi Action
int Volte=2;

public class Ascoltatore implements ActionListener
{
	public void actionPerformed (ActionEvent e)
	{
		String Comando=e.getActionCommand();
		if (Comando.compareTo("CLICK")==0)
		{
			cliccato.setText("Mi hai cliccato");
			cliccami.setLabel("Ricliccami");
			cliccami.setActionCommand("RECLICK");
		};
		
		if (Comando.compareTo("RECLICK")==0)
			cliccato.setText("Mi hai cliccato "+(Volte++)+" volte.");
}
}// Fine Ascoltatore
}// Fine Bottone