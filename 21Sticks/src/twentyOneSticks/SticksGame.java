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
	private static SticksMain SticksMain = new SticksMain(); //accesses the code from SticksMain
	private static sticksPicture sticksPicture = new sticksPicture(); //accesses the code from sticksPicture
	public static int computerWins = 0; //declares and initializes variable computerWins 
	public static int userWins = 0; //declares and initializes variable userWins
	public static int playAgain; //declares variable playAgain
	public static int answer; //declares variable answer
	
	public static void main(String[] args) //main of this class
	{
		//JOptionPane that explains the rules of the game
		JOptionPane.showMessageDialog(null, "Rules for 21 Sticks: \n" +
				"You will choose whether you or the computer goes first.\n"
				+ "Then you and the computer will take turns removing either \n"
				+ "one or two sticks from the original 21 until there are no \n"
				+ "more sticks. The player that takes the last stick loses. \n"
				+ "Game on.");
		sticksGame(); //calls the method sticksGame
	}
	
	public static void sticksGame() //method sticksGame
	{	
		int numSticks = 21; //declares and initializes variable numSticks
		
		int numToTake = 0; //declares and initializes variable numToTake 
		Object[] place = {"1", "2"}; //creates array for options for the JOptionPane.showConfirmDialog
		
		//do-while loop for asking the user if they want to play again
		do
		{
			numSticks = 21; //resets the variable numSticks to 21 
			answer = JOptionPane.showConfirmDialog(null, "Would you like to go first?"); //sets value of answer to what user answers
			if(answer == 0) //if the value of answer is equal to 0, enter this code
			{	
				while(numSticks > 0) //while, numSticks is greater than 0, enter this code
				{
					//Tells user how many sticks are left
					JOptionPane.showMessageDialog(null, "There are " + numSticks + " sticks.");
					
					//sets answer to what the user responds with 
					answer = JOptionPane.showOptionDialog(null, "Would you like to take 1 or 2 sticks?", null, 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, place, 
							place[0]);
					if(answer == 0) //if value of answer is equal to 0, enter this code
					{
						//System.out.print("user took one");
						sticksPicture.userTakesOne(); //calls method from sticksPicture
						numToTake = 1; //sets numToTake equal to 1
					}
					else if(answer == 1) //if value of answer is equal to 1, enter this code
					{
						//System.out.print("user took two"); 
						sticksPicture.userTakesTwo(); //calls method from sticksPicture
						numToTake = 2; //sets numToTake equal to 2
					}
					
					numSticks = numSticks - numToTake; //subtracts whatever numToTake is equal to from numSticks
					
					if(numSticks <= 0) //if the number of sticks is less than 0 after your move, you lose
					{
						JOptionPane.showMessageDialog(null, "You lose!"); //informs user that they have lost
						computerwins(); //calls method computer wins 
					}
					else //continue with code if the number of sticks is still more than 0
					{
						if((numSticks - 2) % 3 == 0 || numSticks - 2 == 0) //determines whether computer will take 1 or 2
						{
							sticksPicture.computerTakesOne(); //calls method from sticksPicture
							numToTake = 1; //sets numToTake equal to 1
						}
						else //if not, computer takes 2
						{
							sticksPicture.computerTakesTwo(); //calls method from sticksPicture
							numToTake = 2; //sets numToTake equal to 2
						}

						numSticks = numSticks - numToTake; //subtracts numToTake from however many sticks are left
					
						if(numSticks<=0) //if the number of sticks after computer goes is greater than 0, you win
						{
							JOptionPane.showMessageDialog(null, "You Win!"); //tells user that they won
							userwins(); //calls method userwins(); 
						}
					}
				};
			}
			else if(answer == 1) //if user enters that computer goes first
			{
				do //method to continue until amount of sticks is less than 0 
				{
					if((numSticks - 2) % 3 == 0 || numSticks - 2 == 0) //again calculates whether the computer will pick 1 or 2
					{
						sticksPicture.computerTakesOne(); //calls method computerTakesOne from class sticksPicture
						numToTake = 1; //sets numToTake equal to 1
					}
					else //if computer will take 2, enter here
					{
						sticksPicture.computerTakesTwo(); //calls method computerTakesTwo from class sticksPicture
						numToTake = 2; //sets numToTake equal to 2
					}
					
					numSticks = numSticks - numToTake; //subtracts numToTake from numSticks and sets equal to numSticks
					
					if(numSticks <= 0) //if numSticks is less than or equal to 0 after computer goes
					{
						JOptionPane.showMessageDialog(null, "You Win!"); //you win 
						userwins(); //calls method userwins(); 
					}
					else //if numSticks is greater than 0 
					{
						//tells user how many sticks are left
						JOptionPane.showMessageDialog(null, "There are " + numSticks + " sticks left.");
						answer = JOptionPane.showOptionDialog(null, "Would you like to take 1 or 2 sticks?", null, 
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, place, 
								place[0]);
						if(answer == 0) //if value of answer is equal to 0, enter this code
						{
							sticksPicture.userTakesOne(); //calls method userTakesOne from class sticksPicture
							numToTake = 1; //sets numToTake equal to 1
						}
						else if(answer == 1) //if value of answer is equal to 1, enter this code
						{
							sticksPicture.userTakesTwo(); //calls method userTakesTwo from class sticksPicture
							numToTake = 2; //sets numToTake equal to 2
						}
						
						numSticks = numSticks - numToTake; //subtracts numToTake from numSticks and sets equal to numSticks
						
						if(numSticks <= 0) //if numSticks is less than or equal to 0 after your turn
						{
							JOptionPane.showMessageDialog(null, "You Lose!"); //you lost the game
							computerwins(); //calls method computerwins(); 
						}
					}
				}while(numSticks >= 0); //while number of sticks is greater than or equal to 0, continue running loop
			}
			
			playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?"); //asks user if they want to play agian
			
		}while(playAgain == 0); //while the value of playAgain is equal to 0, continue this loop
		
		SticksMain.userChoice(); 
	}
	
	public static void userwins() //method userwins
	{
		try 
		{
			PrintWriter gameStandings = new PrintWriter("GameStandings.txt"); //creates printwriter for the game standings
			userWins = userWins + 1; //adds 1 to the amount of times that user has won
			gameStandings.println("User has won " + userWins + " time(s)."); //prints this information into the file
			gameStandings.println("The computer has won " + computerWins + " time(s)."); //prints this information into file
			gameStandings.close(); //closes print writer
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e); //prints e
		}
	
	}
	
	public static void computerwins() //method computerwins()
	{ 
		try 
		{
			PrintWriter gameStandings = new PrintWriter("GameStandings.txt"); //creates printwriter for game standings
			computerWins = computerWins + 1; //adds one to the amount of times the computer has won
			gameStandings.println("The computer has won " + computerWins + " time(s)."); //prints information into the file
			gameStandings.println("User has won " + userWins + " time(s)."); //prints information into the file
			gameStandings.close(); //closes print writer
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e); 
		}
	}
}