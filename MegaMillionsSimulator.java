import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.*;

public class MegaMillionsSimulator extends JFrame
{
        private JPanel purchaseTicketsPanel;
        private JLabel purchaseTicketsLabel;
        private JTextField ticketsToPurchaseField; 
        private JButton purchaseTicketsButton;
        
        private JPanel winningTicketJPanel;
        private JLabel winningTicketLabel;
        
        private JPanel totalsJPanel;
        
        private JLabel totalSpentLabel;
        private double totalSpent;
        
        private JLabel totalWonLabel;
        private double totalWon;
        
        private JLabel netProfitLabel;
        private double netProfit;
        
        private final int WINDOW_WIDTH = 500;
   private final int WINDOW_HEIGHT = 200;
        
        public MegaMillionsSimulator()
        {
                setTitle("Mega Millions Simulator");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                
                setLayout(new BorderLayout());
                
                purchaseTicketsPanel = new JPanel();
                
                purchaseTicketsLabel = new JLabel("Enter the # of tickets you want to buy");
                purchaseTicketsPanel.add(purchaseTicketsLabel);
                
                ticketsToPurchaseField = new JTextField(10);
                purchaseTicketsPanel.add(ticketsToPurchaseField);
                
                purchaseTicketsButton = new JButton("Purchase!");
                purchaseTicketsButton.addActionListener(new PurchaseTicketsButtonListener());

                purchaseTicketsPanel.add(purchaseTicketsButton);
                
                add(purchaseTicketsPanel, BorderLayout.NORTH);
                
                winningTicketJPanel = new JPanel();
                winningTicketLabel = new JLabel();
                winningTicketJPanel.add(winningTicketLabel);
                add(winningTicketJPanel, BorderLayout.CENTER);
                
                totalsJPanel = new JPanel();
                
                totalSpent = 0.0;
                totalSpentLabel = new JLabel();
                totalsJPanel.add(totalSpentLabel);
                
                totalWon = 0.0;
                totalWonLabel = new JLabel();
                totalsJPanel.add(totalWonLabel);
                
                netProfit = 0.0;
                netProfitLabel = new JLabel();
                totalsJPanel.add(netProfitLabel);
                
                updateLabels();
                
                add(totalsJPanel, BorderLayout.SOUTH);
        
                setVisible(true);
        }
        
        private void updateLabels()
        {
                DecimalFormat dollar = new DecimalFormat("#,##0.00");
                totalSpentLabel.setText("Total spent: $" + 
                        dollar.format(totalSpent));
                totalWonLabel.setText("Total won: $" + dollar.format(totalWon));
                netProfit = totalWon - totalSpent;
                netProfitLabel.setText("Net Profit: $" + dollar.format(netProfit));
        }
        
        public static void main(String[] args)
        {
                MegaMillionsSimulator megaMillionsSimulator = new MegaMillionsSimulator();
        }
        
        private class PurchaseTicketsButtonListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
      {
                    int ticketsPurchased = Integer.parseInt(ticketsToPurchaseField.getText());
                         totalSpent += ticketsPurchased * MegaMillionsTicket.PRICE_PER_TICKET;
                        
                        MegaMillionsTicket winningTicket = new MegaMillionsTicket();
                        //MegaMillionsTicket[] megaMillionsTickets = new MegaMillionsTicket[ticketsPurchased];

                        winningTicketLabel.setText( "Winning Ticket: " + winningTicket.toString() );
                        
         for ( int index = 0; index < ticketsPurchased; index++ )
                        //for ( int index = 0; index < powerBallTickets.length; index++ )
                        {
                                //megaMillionsTickets[index] = new MegaMillionsTicket();
                                //totalWon += megaMillionsTickets[index].getWinnings(winningTicket);
            totalWon += new MegaMillionsTicket().getWinnings(winningTicket);
                        }
                        
                        updateLabels();
      }
        }
}