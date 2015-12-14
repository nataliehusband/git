package twentyOneSticks;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//sources
//http://www.java-made-easy.com/fun-java-game.html
//http://stackoverflow.com/questions/32062761/change-button-text-in-joptionpane-showconfirmdialog
//http://stackoverflow.com/questions/8396870/joptionpane-yes-or-no-window
	
import javax.swing.JOptionPane;

public class SticksGame 
{
	private static SticksMain SticksMain = new SticksMain();
	private static sticksPicture sticksPicture = new sticksPicture(); 
	public static int computerWins = 0; 
	public static int userWins = 0;
	public static int playAgain; 	
	public static int answer;
	//this.Username(); 
	
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "Rules for 21 Sticks: \n" +
				"You will choose whether you or the computer goes first.\n"
				+ "Then you and the computer will take turns removing either \n"
				+ "one or two sticks from the original 21 until there are no \n"
				+ "more sticks. The player that takes the last stick loses. \n"
				+ "Game on.");
		sticksGame(); 
	}
	
	public static void sticksGame()
	{	
		int numSticks = 21; 
		
		int numToTake = 0; 
		Object[] place = {"1", "2"}; 
		
		do
		{
			numSticks = 21;
			answer = JOptionPane.showConfirmDialog(null, "Would you like to go first?"); 
			if(answer == 0)
			{	
				while(numSticks > 0)
				{
					//sticksPicture.tellUser();

					JOptionPane.showMessageDialog(null, "There are " + numSticks + " sticks.");
					answer = JOptionPane.showOptionDialog(null, "Would you like to take 1 or 2 sticks?", null, 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, place, 
							place[0]);
					if(answer == 0)
					{
						System.out.print("user took one"); 
						sticksPicture.userTakesOne(); 
						numToTake = 1; 
					}
					else if(answer == 1)
					{
						System.out.print("user took two"); 
						sticksPicture.userTakesTwo(); 
						numToTake = 2; 
					}
					
					numSticks = numSticks - numToTake; 
					
					if(numSticks <= 0)
					{
						JOptionPane.showMessageDialog(null, "You lose!");
						computerwins(); 
					}
					else
					{
						if((numSticks - 2) % 3 == 0 || numSticks - 2 == 0)
						{
							sticksPicture.computerTakesOne();
							numToTake = 1; 
						}
						else
						{
							sticksPicture.computerTakesTwo();
							numToTake = 2; 
						}
						//JOptionPane.showMessageDialog(null, "Computer takes: " + numToTake + " sticks.");
						numSticks = numSticks - numToTake; 
					
						if(numSticks<=0)
						{
							JOptionPane.showMessageDialog(null, "You Win!");
							userwins(); 
						}
					}
				};
			}
			else if(answer == 1)
			{
				do
				{
					if((numSticks - 2) % 3 == 0 || numSticks - 2 == 0)
					{
						sticksPicture.computerTakesOne();
						numToTake = 1; 
					}
					else
					{
						sticksPicture.computerTakesTwo();
						numToTake = 2; 
					}
					//JOptionPane.showMessageDialog(null, "Computer takes: " + numToTake + " sticks.");
					
					numSticks = numSticks - numToTake; 
					
					if(numSticks <= 0)
					{
						JOptionPane.showMessageDialog(null, "You Win!");
						userwins(); 
					}
					else
					{
						JOptionPane.showMessageDialog(null, "There are " + numSticks + " sticks left.");
						answer = JOptionPane.showOptionDialog(null, "Would you like to take 1 or 2 sticks?", null, 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, place, 
								place[0]);
						if(answer == 0)
						{
							sticksPicture.userTakesOne();
							numToTake = 1; 
						}
						else if(answer == 1)
						{
							sticksPicture.userTakesTwo();
							numToTake = 2; 
						}
						
						numSticks = numSticks - numToTake; 
						
						if(numSticks <= 0)
						{
							JOptionPane.showMessageDialog(null, "You Lose!");
							computerwins(); 
						}
					}
				}while(numSticks >= 0);
			}
			
			playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?"); 
			
		}while(playAgain == 0); 
	}
	
	public static void userwins()
	{
		try 
		{
			PrintWriter gameStandings = new PrintWriter("GameStandings.txt");	
			userWins = userWins + 1; 
			gameStandings.println("User has won " + userWins + " time(s).");	
			gameStandings.println("The computer has won " + computerWins + " time(s).");
			gameStandings.close(); 
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
	
	}
	
	public static void computerwins()
	{ 
		try 
		{
			PrintWriter gameStandings = new PrintWriter("GameStandings.txt");	
			computerWins = computerWins + 1; 
			gameStandings.println("The computer has won " + computerWins + " time(s).");
			gameStandings.println("User has won " + userWins + " time(s).");	
			gameStandings.close(); 
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e); 
		}
	}
}
