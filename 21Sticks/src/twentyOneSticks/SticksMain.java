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
	private static SticksScore SticksScore = new SticksScore(); 
	private static SticksGame SticksGame = new SticksGame(); 
	static String Username; 
	static String Password; 
	static String Username2; 
	static String Password2; 	
	
	public static void main (String[] args) throws IOException
	{
		File ReadAccount = new File("ReadAccount.txt"); 
		int account; 
		
		Object[] Answer = {"Create an Account", "Log in"}; 
		
		account = JOptionPane.showOptionDialog(null, "Welcome to 21 Sticks!", null, 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Answer, 
				Answer[0]);
		
		if(account == 0)
		{
			try 
			{
				PrintWriter SeeAccount = new PrintWriter("SeeAccount.txt");
				Username = JOptionPane.showInputDialog("Enter a username:");
				SeeAccount.println(Username);
				
				Password = JOptionPane.showInputDialog("Enter a Password:");
				SeeAccount.println(Password); 
				SeeAccount.close(); 
				main(args); 
			} 
			catch (FileNotFoundException e)  
			{
				System.out.print(e); 
			} 
		}
		else if(account == 1)
		{
			BufferedReader br = new BufferedReader(new FileReader("SeeAccount.txt"));
			String fileUsername = br.readLine();
			String filePassword = br.readLine();
			br.close();
			
			Username2 = JOptionPane.showInputDialog("Username:");
			if(Username2.equals(fileUsername))
			{
				Password2 = JOptionPane.showInputDialog("Password:");
				
				if(Password2.equals(filePassword))
				{
					userChoice(); 
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password. Please try again");
					main(args); 
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect Username. Please try again."); 
				main(args); 
			} 	
		} 
	}
	
	public static void userChoice()
	{
		Object[] Response = {"Play the Sticks Game", "View Game Standings"};
		int response; 
		response = JOptionPane.showOptionDialog(null,  "Welcome!\n" +
					"What would you like to do?", null, JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, Response, Response[0]);
		if(response == 0)
		{
			SticksGame.main(null);
		}
		else if(response == 1)
		{
			try 
			{
				SticksScore.main(null);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}