package horses;

//comment for branch
import java.io.File;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HorseTypes 
{
	public static final String TYPES[] = {"Horse", "Pony", "Draft"};
	public static void main(String[] args)
	{
		HorseGender myTestHorseTypes[] = new HorseGender[3]; 
		for(int h=0; h<3; h++)
		{
			myTestHorseTypes[h] = new HorseGender(TYPES[h]); 
			System.out.println(myTestHorseTypes[h].getType() + ":");
			myTestHorseTypes[h].setHeight();
			System.out.println(myTestHorseTypes[h].getHeight() + " hands tall");
			myTestHorseTypes[0].setEyes(3);
			myTestHorseTypes[h].getEyes(); 
			System.out.println(myTestHorseTypes[h].getEyes() + " eyes");
			System.out.println(myTestHorseTypes[h].getLegs() + " legs");
			System.out.println(myTestHorseTypes[h].getEars() + " ears\n");
		}
		
		try
		{
			try
			{
				Sound();
			}
			catch(FileNotFoundException e)
			{
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			Thread.sleep(2000);

		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void Sound() throws Exception
	{ 
		File url = new File("neigh.wav");
		Clip clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream( url );
		clip.open(ais);
	    clip.loop(0);   
	}
}
