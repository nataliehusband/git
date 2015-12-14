package twentyOneSticks;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class sticksPicture 
{
	private static SticksGame SticksGame = new SticksGame();
	
	public static void userTakesOne()
	{
		ImageIcon onestick = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/onestick.jpg");
		JOptionPane.showMessageDialog(null, "You took 1 stick!", null, 0, onestick);
	}
	
	public static void userTakesTwo()
	{
		ImageIcon twosticks = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/twosticks.jpg"); 
		JOptionPane.showMessageDialog(null, "You took 2 sticks!", null, 0, twosticks);
	}
	
	public static void computerTakesOne()
	{
		ImageIcon onestick = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/onestick.jpg");
		JOptionPane.showMessageDialog(null, "Computer took 1 stick!", null, 0, onestick);
	}
	
	public static void computerTakesTwo()
	{
		ImageIcon twosticks = new ImageIcon("/Users/nataliehusband/Documents/git/21sticks/images/twosticks.jpg");
		JOptionPane.showMessageDialog(null, "Computer took 2 sticks!", null, 0, twosticks); 
	}
}

