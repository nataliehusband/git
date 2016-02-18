package horses;

//comment for branch
public class HorseGender extends SetHorses
{
	HorseTypes HorseTypes = new HorseTypes(); 
	private String type; 
	private int height; 
	private String color; 
	private int weight; 

	public HorseGender(String t) 
	{
		type = t; 
		height = 0; 
		//color = ""; 
		//weight = 0; 
	}

	public void setType(String t)
	{
		type = t; 
	}
	
	public String getType()
	{
		return(type); 
	}
	
	public void setHeight()
	{
		if(type == "Horse")
		{
			height = 16; 
		}
		else if(type == "Pony")
		{
			height = 14; 
		}
		else if(type =="Draft")
		{
			height = 18; 
		}
	}
	
	public int getHeight()
	{
		return(height); 
	}
	
	public void setEyes(int eye)
	{
		eyes = eye;  
	}
	
	@Override
	public int getEyes()
	{
		return(eyes); 
	}
}
