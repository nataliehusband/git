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
	public static SticksMain SticksMain = new SticksMain(); 
	public static int computerWins = 0; 
	public static int userWins = 0;
	private static FlowLayout layout = new FlowLayout();  
	
	public static void main(String[] args) throws IOException
	{
		//Scanner readGame = new Scanner("GameStandings.txt");
		BufferedReader score = new BufferedReader(new FileReader("GameStandings.txt"));
		String fileScore = score.readLine(); 
		String filesScore = score.readLine(); 
		score.close(); 
		
		JLabel userScore = new JLabel(filesScore); 
		JLabel computerScore = new JLabel(fileScore); 
		JFrame displayScore = new JFrame(); 
		JLabel scoreText = new JLabel("\nThe standings are:"); 
		displayScore.setDefaultCloseOperation(displayScore.EXIT_ON_CLOSE);
		displayScore.setSize(250, 200);
		displayScore.setLayout(layout);		
		displayScore.setLocationRelativeTo(null);
		
		JButton goHome = new JButton("Return to Home"); 
		goHome.addActionListener(
				new ActionListener()
				{
					@SuppressWarnings("static-access")
					public void actionPerformed(ActionEvent event)
					{
						displayScore.setVisible(false);
						SticksMain.userChoice(); 
					}
				}
				);
		
		JButton quit = new JButton("Quit Program");
		quit.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						System.exit(0);
					}
				}
				);
		
		displayScore.add(scoreText);
		displayScore.add(userScore); 
		displayScore.add(computerScore);
		displayScore.add(goHome);
		displayScore.add(quit);
		
		displayScore.setVisible(true);
	}
}
