import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator
{
   public static void main(String[] args)
   {
      CalculatorFrame frame = new CalculatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   Un frame con un pannello calcolatore.
*/
class CalculatorFrame extends JFrame
{
   public CalculatorFrame()
   {
      setTitle("Calculator");

      Container contentPane = getContentPane();
      CalculatorPanel panel = new CalculatorPanel();
      contentPane.add(panel);
      pack();
   }
}


/**
   Un pannello con pulsanti di calcolatrice e display per i risultati.
*/
class CalculatorPanel extends JPanel
{
   public CalculatorPanel()
   {
      setLayout(new BorderLayout());

      result = 0;
      lastCommand = "=";
      start = true;

      // aggiunge il display

      display = new JLabel("0");
      add(display, BorderLayout.NORTH);

      ActionListener insert = new InsertAction();
      ActionListener command = new CommandAction();

      // aggiunge i pulsanti in una griglia 4 x 4

      panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4));

      addButton("7", insert);
      addButton("8", insert);
      addButton("9", insert);
      addButton("/", command);

      addButton("4", insert);
      addButton("5", insert);
      addButton("6", insert);
      addButton("*", command);

      addButton("1", insert);
      addButton("2", insert);
      addButton("3", insert);
      addButton("-", command);

      addButton("0", insert);
      addButton(".", insert);
      addButton("=", command);
      addButton("+", command);

      add(panel, BorderLayout.CENTER);
   }

   /**
      Aggiunge un pulsante al pannello centrale.
      @param label l'etichetta del pulsante
      @param listener il rilevatore del pulsante
   */
   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.addActionListener(listener);
      panel.add(button);
   }

   /**
      Questa azione inserisce la stringa di azione del pulsante alla
      fine del testo visualizzato.
   */
   private class InsertAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String input = event.getActionCommand();
         if (start)
         {
            display.setText("");
            start = false;
         }
         display.setText(display.getText() + input);
      }
   }

   /**
      Questa azione esegue il comando denotato dalla stringa
      di azione del pulsante.
   */
   private class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent evt)
      {
         String command = evt.getActionCommand();

         if (start)
         {
            if (command.equals("-"))
            {
               display.setText(command);
               start = false;
            }
            else
               lastCommand = command;
         }
         else
         {
            calculate(Double.parseDouble(display.getText()));
            lastCommand = command;
            start = true;
         }
      }
   }

   /**
      Esegue il calcolo in sospeso.
      @param x il valore da accumulare con il risultato precedente.
   */
   public void calculate(double x)
   {
      if (lastCommand.equals("+")) result += x;
      else if (lastCommand.equals("-")) result -= x;
      else if (lastCommand.equals("*")) result *= x;
      else if (lastCommand.equals("/")) result /= x;
      else if (lastCommand.equals("=")) result = x;
      display.setText("" + result);
   }

   private JLabel display;
   private JPanel panel;
   private double result;
   private String lastCommand;
   private boolean start;
}
