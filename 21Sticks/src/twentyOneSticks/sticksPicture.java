package twentyOneSticks;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class sticksPicture //class sticksPicture
{
	private static SticksGame SticksGame = new SticksGame(); //accesses code from SticksGame
	
	public static void userTakesOne() //method userTakesOne
	{
		//Creates an image icon for one stick 
		ImageIcon onestick = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/onestick.jpg");
		JOptionPane.showMessageDialog(null, "You took 1 stick!", null, 0, onestick); //displays the information with image icon
	}
	
	public static void userTakesTwo() //method userTakesOne
	{
		//creates an image icon for two sticks
		ImageIcon twosticks = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/twosticks.jpg"); 
		JOptionPane.showMessageDialog(null, "You took 2 sticks!", null, 0, twosticks); //displays the information with image icon
	}
	
	public static void computerTakesOne() //method userTakesOne
	{
		//creates an image icon for one stick
		ImageIcon onestick = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/onestick.jpg");
		JOptionPane.showMessageDialog(null, "Computer took 1 stick!", null, 0, onestick); //displays information with image icon
	}
	
	public static void computerTakesTwo() //method userTakesTwo
	{
		//creates an image icon for two sticks
		ImageIcon twosticks = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/twosticks.jpg");
		JOptionPane.showMessageDialog(null, "Computer took 2 sticks!", null, 0, twosticks); //displays information with image icon
	}
}

