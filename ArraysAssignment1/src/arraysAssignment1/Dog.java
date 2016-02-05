package arraysAssignment1;

import javax.swing.JOptionPane;

public class Dog //class Dog 
{	
	private static ArraysAssignment1 ArraysAssignment1 = new ArraysAssignment1(); 
	
	public static void Golden(String[] choices) //method Golden 
	{			
		//If the user chose Golden Retriever, this is the message that will be displayed
		JOptionPane.showMessageDialog(null, "Golden Retreivers have long, "
				+ "golden fur and have mouths soft enough that they can "
				+ "carry an egg without breaking the shell.");
	}
	
	public static void Boxer(String[] choices) //method Boxer
	{
		//if the user chose Boxer, this is the message that will be displayed
		JOptionPane.showMessageDialog(null, "Boxers tails are docked because"
				+ " originally they were hunters. Also, a boxer holds a Guinness "
				+ "world record for having the longest tongue!");
	}
	
	public static void Husky(String[] choices) //method Husky
	{
		//if the user chose Husky, this is the message that will be displayed
		JOptionPane.showMessageDialog(null, "Huskies are bred to thrive in very"
				+ " cold temperatures! They are commonly used to pull sleds and"
				+ " are raced in this manner!");
	}
	
	public static void Chihuahua(String[] choices) //Chihuahua
	{
		//if the user chose Chihuahua, this is the message that will be displayed 
		JOptionPane.showMessageDialog(null,  "Chihuahuas are small dogs that are"
				+ " commonly believed to be inherintly naughty. However, when "
				+ "properly trained these little dogs are quite well behaved.");
	}
}
