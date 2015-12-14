package twentyOneSticks;

//sources
//http://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SticksScore 
{
	public static SticksMain SticksMain = new SticksMain(); //accesses the code from SticksMain
	public static int computerWins = 0; //declares and initializes computerWins
	public static int userWins = 0; //declares and initializes userWins
	private static FlowLayout layout = new FlowLayout(); //creates the FlowLayout
	
	public static void main(String[] args) throws IOException //main of this class
	{
		BufferedReader score = new BufferedReader(new FileReader("GameStandings.txt")); //creates a file reader
		String fileScore = score.readLine(); //sets the String fileScore to what the file reader reads from the file
		String filesScore = score.readLine(); //sets the String filesScore to what the file reader reads from the file
		score.close(); //closes the file reader
		
		JLabel userScore = new JLabel(filesScore); //creates a new JLabel
		JLabel computerScore = new JLabel(fileScore); //creates a new JLabel
		JFrame displayScore = new JFrame(); //creates a new JFrame
		JLabel scoreText = new JLabel("\nThe standings are:"); //creates a new JLabel
		displayScore.setDefaultCloseOperation(displayScore.EXIT_ON_CLOSE); //sets the close operation of the JFrame
		displayScore.setSize(250, 200); //sets size of JFrame
		displayScore.setLayout(layout); //sets Layout of JFrame
		displayScore.setLocationRelativeTo(null); //sets the location of the JFrame
		
		JButton goHome = new JButton("Return to Home"); //creates a new JButton
		goHome.addActionListener( //adds action listener to the JButton
				new ActionListener()
				{
					@SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent event)
					{
						displayScore.setVisible(false); //sets the visibility of the JFrame to false
						SticksMain.userChoice(); //calls the method userChoice when this button is clicked
					}
				}
				);
		
		JButton quit = new JButton("Quit Program"); //creates a new JButton
		quit.addActionListener( //adds action listener to the JButton
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent event)
					{
						System.exit(0); //quits the program when this button is clicked
					}
				}
				);
		
		displayScore.add(scoreText); //adds the JLabel scoreText to the JFrame
		displayScore.add(userScore); //adds the JLabel userScore to the JFrame
		displayScore.add(computerScore); //adds the JLabel computerScore to the JFrame
		displayScore.add(goHome); //adds the JButton goHome to the JFrame
		displayScore.add(quit); //adds the JButton quit to the Jframe
		
		displayScore.setVisible(true); //sets the visibility of the JFrame 
	}
}
