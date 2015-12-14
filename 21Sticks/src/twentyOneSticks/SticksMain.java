package twentyOneSticks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SticksMain 
{
	private static SticksScore SticksScore = new SticksScore(); //accesses the class SticksScore
	private static SticksGame SticksGame = new SticksGame(); //accesses the class SticksGame
	static String Username; //Declares variable Username
	static String Password; //Declares variable Password
	static String Username2; //Declares variable Username2
	static String Password2; //Declares variable Password2
	
	public static void main (String[] args) throws IOException //the main program for the sticks game
	{
	//	File ReadAccount = new File("ReadAccount.txt"); //creates a file for reading account information
		int account; //declares variable account as an int to be used for the JOptionPane.showConfirmDialog
		
		Object[] Answer = {"Create an Account", "Log in"}; //creates array for choices for the ConfirmDialog
		
		//JOptionPane for the confirm dialog so the user can choose what they are going to do
		//either log in or create a new account
		account = JOptionPane.showOptionDialog(null, "Welcome to 21 Sticks!", null, 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Answer, 
				Answer[0]);
		
		if(account == 0) //if the value of account is equal to 0, then enter this code
		{
			try //try-catch for the PrintWriter
			{
				PrintWriter SeeAccount = new PrintWriter("SeeAccount.txt"); //creates the PrintWriter to write to files
				Username = JOptionPane.showInputDialog("Enter a username:"); //sets Username equal to what the user enteres
				SeeAccount.println(Username); //prints the username to the file SeeAccount
				
				Password = JOptionPane.showInputDialog("Enter a Password:"); //sets Password equal to what the user enters
				SeeAccount.println(Password); //prints the password the the file SeeAccount
				SeeAccount.close(); //closes the PrintWriter
				main(args); //calls the main of the program so it takes the user back so they can log in 
			} 
			catch (FileNotFoundException e)  //catch of the try-catch
			{
				System.out.print(e); //prints out e 
			} 
		}
		else if(account == 1) //if the value of account is equal to 1, then enter this code
		{
			BufferedReader br = new BufferedReader(new FileReader("SeeAccount.txt")); //creates a filereader to read the file
			String fileUsername = br.readLine(); //reads the first line of the file for the username
			String filePassword = br.readLine(); //reads the second line of the file for the password
			br.close(); //closes the file reader
			
			Username2 = JOptionPane.showInputDialog("Username:"); //sets Username2 to what user enters as their username
			if(Username2.equals(fileUsername)) //compares this username to the one saved in the file, if equal, enter code
			{
				Password2 = JOptionPane.showInputDialog("Password:"); //sets Password2 to what user enters as their password
				
				if(Password2.equals(filePassword)) //compares this password to the one saved in the file, if equal, enter code
				{
					userChoice(); //calls the method userChoice(); 
				}
				else //if the password does not equal the one in the file, show this code
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password. Please try again"); 
					main(args); //calls the main and takes the user back so they can try again
				}
			}
			else //if the username does not equal the one in the file, show this code
			{
				JOptionPane.showMessageDialog(null, "Incorrect Username. Please try again."); 
				main(args); //calls the main and takes the user back so they can try again
			} 	
		} 
	}
	
	public static void userChoice() //method userChoice()
	{
		Object[] Response = {"Play the Sticks Game", "View Game Standings"}; //array for choices in the optionDiolog
		int response; //declares variable response
		
		//sets int response equal to the value that the user enters by selecting one of the options
		response = JOptionPane.showOptionDialog(null,  "Welcome!\n" +
					"What would you like to do?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, Response, Response[0]);
		if(response == 0) //if value of response is equal to 0, enter this code
		{
			SticksGame.main(null); //calls the class SticksGame and it's main
		}
		else if(response == 1) //if value of response is equal to 1, enter this code
		{
			try //try-catch for the calling of this class
			{
				SticksScore.main(null); //calls the class SticksScore 
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}