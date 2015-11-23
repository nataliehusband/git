package fileRead;

//used the code examples on moodle to write this code

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadingFile 
{
	//creates the static string variables necessary to run the program 
	private static String firstName, lastName, middleInitial, birthState; 
	
	public static void main(String[] args)
	{
		File Read = new File("file.txt");
		//FileOutputStream fileOut; 
		//System.out.println(System.getProperty("user.dir"));
		
		try //creates the try/catch
		{
			//fileOut = new FileOutputStream(Read);
			Scanner scan = new Scanner(Read); //creates the scanner 'scan' that scans one file for the variables that are placed into the other
			PrintWriter stream = new PrintWriter("fileout.txt"); //creates the PrintWriter 'stream' (file that writes information from first file)
			
			System.out.println("What is your first name?"); //asks what first name is
			firstName = scan.next(); //scans first file for the name 
			
			System.out.println("What is your middle initial?"); //asks what middle initial is
			middleInitial = scan.next(); //scans first file for middle initial 
			
			System.out.println("What is your last name?"); //asks what last name is
			lastName = scan.next(); //scans first file for last name
			stream.println("Name = " + firstName + " " + middleInitial + ". " + lastName); //puts information from file.txt into fileout.txt
			
			System.out.println("Where state were you born in?"); //asks what state user was born in 
			birthState = scan.next(); //scans file.txt for the birth state
			stream.println("State where user was born: " + birthState); //prints birth state from file.txt into fileout.txt
			
			stream.close(); //closes the stream
			//scan.close(); 
		}
		catch(FileNotFoundException e) //catch
		{
			System.out.print(e); //prints e
		}
	}
}
