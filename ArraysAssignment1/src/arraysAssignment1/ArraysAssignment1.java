package arraysAssignment1;

//sources:
//http://stackoverflow.com/questions/19809739/call-a-class-from-another-class
//http://www.java2s.com/Tutorial/Java/0240__Swing/Todisplaysadialogwithalistofchoicesinadropdownlistbox.htm

import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArraysAssignment1 
{
	private static Dog Dog = new Dog(); //imports the class Dog 
	private static ThreeDim ThreeDim = new ThreeDim(); //imports the class ThreeDim 
	private static String[] choices = new String[4]; //creates array choices for the choices of dog breeds
	private static String input; //declares string variable input
	
	public static void main(String[] args) 
	{	
		//declares and initializes String array cities 
		String[][] cities = 
			{
					{"Denver", "Colorado"},
					{"Portland", "Oregon"},
					{"Seattle", "Washington"}, 
					{"Sacramento", "California"}
			};
		
		//declares and initializes double array temperatures
		double[] temperatures = 
			{
					30.9, 54.5, 51, 60.95 	
			};	
		
		//prints the average temperatures of each othe cities in their respective states
		System.out.println("The average temperature of " + cities[0][0] + ", " + cities[0][1] 
				+ " is " + temperatures[0] + " degrees Farenheit.");
		System.out.println("The average temperature of " + cities[1][0] + ", " + cities[1][1]
				+ " is " + temperatures[1] + " degrees Farenheit.");
		System.out.println("The average temperature of " + cities[2][0] + ", " + cities[2][1]
				+ " is " + temperatures[2] + " degrees Farenheit.");
		System.out.println("The average temperature of " + cities[3][0] + ", " + cities[3][1]
				+ " is " + temperatures[3] + " degrees Farenheit.");
	
		setBreeds(); //calls method setBreeds
		for(int a=0; a<1; a++) //for loop that will run through so that you can choose a dog breed
		{
			input = (String) JOptionPane.showInputDialog(null, "Choose a dog breed", "Dog Breeds", 
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
			//System.out.println(input); 
			breedResults(); //calls method breedResults
		}
		 
		ThreeDim.threeDim(); //calls method threeDim from the class ThreeDim
	}
	
	private static void setBreeds() //method setBreeds
	{
		choices[0] = "Golden Retriever"; //sets spot 0 in array choices to Golden Retriever
		choices[1] = "Boxer"; //sets spot 1 in array choices to Boxer
		choices[2] = "Husky"; //sets spot 2 in array choices to Husky 
		choices[3] = "Chihuahua"; //sets spot 3 in array choices to Chihuahua 
	}
	
	private static void breedResults() //calls method breedResults
	{
		if(input == choices[0]) //if the choice is Golden Retriever, enters if statement
		{
			Dog.Golden(choices); //calls method Golden from class Dog
		}
		else if(input == choices[1]) //if the choice is Boxer, enters else if statement
		{
			Dog.Boxer(choices); //calls method Boxer from class Dog
		}
		else if(input == choices[2]) //if the choice is Husky, enters else if statement
		{
			Dog.Husky(choices); //calls method Husky from class Dog
		}
		else if(input == choices[3]) //if the choice is Chihuahua, enters else if statement
		{
			Dog.Chihuahua(choices); //calls method Chihuahua from class Dog 
		}
	}
}	

