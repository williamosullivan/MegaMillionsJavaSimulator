import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class MegaMillions extends JFrame
{
   
   private JButton button1;
   private JPanel panel1;
   private JPanel userPicks;
   private JPanel lotteryPanel;
   private JPanel resultsPanel;
   private JLabel messageLabel;
   private JTextField ticketsTextField;
   private final int WINDOW_WIDTH = 400;
   private final int WINDOW_HEIGHT = 100;
   
   Random randomNumbers = new Random();
      
      final int NUMBERS = 5;
      final int MAX_NUMBER = 75;
      final int MEGAMILLIONS = 1;
      final int MAX_MEGAMILLIONS = 15;
      boolean arraysEqual = true;
      int matches = 0;
      int[] userPicks;
      int[] winningPicks;
      int loop;
      
   public MegaMillions()
   {
   
      setTitle("Mega Millions");
      
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setLayout(new BorderLayout());
      
      buildPanel();
      buildUserPanel();
      buildLotteryPanel();
      buildResultsPanel();
 
      add(instructionPanel, BorderLayout.NORTH);
      add(userPanel, BorderLayout.WEST);
      add(lotteryPanel, BorderLayout.EAST);
      add(resultsPanel, BorderLayout.SOUTH);
      
      pack();
      setVisible(true);

      
   }
   
   private void buildPanel()
   {
   
      messageLabel = new JLabel("Enter the number of tickets to purchase");
      ticketsTextField = new JTextField(10);
      button1 = new JButton("GO!");
      
      button1.addActionListener(new ButtonListener());
      
      panel = new JPanel();
      panel.add(messageLabel);
      panel.add(ticketsTextField);
      panel.add(button1);
       
   }
   
   private void buildUserPanel()
   {
   
      userPanel = newJPanel();
      userPicks = new JTextField[NUMBERS];
      
      for (loop = 0; loop <= NUMBERS; loop ++)
      {
      
         userPicks[loop] = new JTextField(userPicks);
         userPanel.add(userPicks[loop]);
         
      }
   }
   
   private void buildLotterPanel()
   {
      lotteryPanel = new JPanel();
      
      draws = new int[MAX_NUMBER];
      
      for (loop = o; loop <= NUMBERS; loop ++)
      {
         winningNumbers[loop] = new JLabel("" + randomNumbers.nextInt(MAX_NUMBER));
         
         draws[loop] ++;
      
      }
   }   
      
   private void buildResultsPanel()
   {
      resultsPanel = new JPanel();
      resultsPanel.add(results);
      
   }               
   
   private class ButtonListener implements ActionListener
   {
   
      public void actionPerformed(ActionEvent e)
      {
         while (arraysEqual && loop < winningPicks)
         {
            if (winningPicks[loop].equals (userPicks[loop]))
            {
               arraysEqual = true;
               matches++;
               loop++;
            }
            else
            {
               arraysEqual = false;
               loop++;
            }
            if (matches <= NUMBERS)
            {
               results = new JLabel("You matched " + matches + " numbers.");
            }
            else
            {
               results = new JLabel("You matched all the numbers! You win the Grand Prize!");
            }      
        }       
      }
   }   
      
   public static void main (String[] args)
   {
   
      MegaMillions megaMillions = new MegaMillions();
      
   }
}          