import java.util.Random;
import javax.swing.JOptionPane;

public class MegaMillionsTicket
{
        public static final int PRICE_PER_TICKET = 1;
        
        private Random random;
        private final int WHITE_BALLS_IN_TICKET = 5;
        private final int NUMBER_OF_WHITE_BALLS = 75;
        private final int NUMBER_OF_YELLOW_BALLS = 15;
        
        private int[] whiteBalls;
        private int yellowBall;
        
        public MegaMillionsTicket()
        {
                random = new Random();
                whiteBalls = new int[WHITE_BALLS_IN_TICKET];
                
                for ( int index = 0; index < whiteBalls.length; index++ )
                {
                        whiteBalls[index] = random.nextInt(NUMBER_OF_WHITE_BALLS) + 1;
                }
                yellowBall = random.nextInt(NUMBER_OF_YELLOW_BALLS) + 1;
        }
        
        
        public MegaMillionsTicket(int w1, int w2, int w3, int w4, int w5, int y)
        {
                whiteBalls[0] = w1;
                whiteBalls[1] = w2;
                whiteBalls[2] = w3;
                whiteBalls[3] = w4;
                whiteBalls[4] = w5;
                yellowBall = y;
        }
        
        public int[] getWhiteBalls()
        {
                return whiteBalls;
        }
        
        public int getYellowBall()
        {
                return yellowBall;
        }
        
        public String toString()
        {
                String ticket = "";
                for ( int whiteBall : whiteBalls )
                {
                        ticket += " " + whiteBall;
                }
                ticket += " Mega Millions Ball: " + yellowBall;
                
                return ticket;
        }
        
        public int getWinnings(MegaMillionsTicket winningTicket)
        {
                int numberOfWhiteMatches = 0;
                int numberOfYellowMatches = 0;
                
                int[] winningTicketWhiteBalls = new int[WHITE_BALLS_IN_TICKET];
                int[] thisTicketWhiteBalls = new int[WHITE_BALLS_IN_TICKET];
      
                
                for ( int index = 0; index < winningTicket.getWhiteBalls().length; index++ )
                {
                        winningTicketWhiteBalls[index] = winningTicket.getWhiteBalls()[index];
         thisTicketWhiteBalls[index] = getWhiteBalls()[index];
                }
                
                if ( winningTicket.getYellowBall() == getYellowBall() )
                {
                        numberOfYellowMatches++;
                }
                
                for ( int winningIndex = 0; winningIndex < winningTicketWhiteBalls.length; winningIndex++ )
                {
                        for ( int index = 0; index < thisTicketWhiteBalls.length; index++ )
                        {
                                if ( thisTicketWhiteBalls[index] == winningTicketWhiteBalls[winningIndex] )
                                {
               numberOfWhiteMatches++;
                                        thisTicketWhiteBalls[index] = 0;
                                        winningTicketWhiteBalls[winningIndex] = -1;
                                }
                        }
                }
                
                if ( numberOfWhiteMatches == 5 && numberOfYellowMatches == 1 )
                {
                        JOptionPane.showMessageDialog(null, "JACKPOT!!!");
                        return 0;
                }
                else if ( numberOfWhiteMatches == 5 )
                {
                        return 1000000;
                }
                else if ( numberOfWhiteMatches == 4 && numberOfYellowMatches == 1 )
                {
                        return 5000;
                }
                else if ( numberOfWhiteMatches == 4 )
                {
                        return 500;
                }
                else if ( numberOfWhiteMatches == 3 && numberOfYellowMatches == 1 )
                {
                        return 50;
                }         
                else if ( numberOfWhiteMatches == 3 || numberOfWhiteMatches == 2 && numberOfYellowMatches == 1 )
                {
                        return 5;
                }
                else if ( numberOfYellowMatches == 1 )
                {
                        return 1;
                }
                else
                {
                        return 0;
                }
        }
}