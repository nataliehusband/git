package arraysAssignment1;

public class ThreeDim 
{
	private static int a, b, c; //declares integers a, b, and c 
	public static void threeDim() //method threeDim
	{
		int[][] array3dim = new int[5][4]; //declares array3Dim and sets parameters

			System.out.println("Table " + (c+1)); //prints the Table number
			for(b = 0; b < 4; b++) //for loop for the second dimension part of the array 
			{
				for(a = 0; a < 5; a++) //for loop for the first dimension part of the array 
				{
					array3dim[a][b] = (2*a)+1; //sets up equation so that each number displayed is odd
					System.out.printf("%3d", array3dim[a][b]); //prints the array 
				}
				System.out.println();	 
			}	
		
		int sum = 0; //declares and initializes sum 
		
		for(int n=0; n<5; n++) //for loop for the addition of one of the lines of the array 
		{
			sum = array3dim[n][0] + sum; //adds a line of the array 
		}
		System.out.println(); 
		System.out.println("The sum of any given row is: " + sum); //prints the sum of one row of the array 
		int average; //declares int average
		average = sum/5; //calculates average of a row of nmbers
		System.out.println(); 
		System.out.println("The average of any given row is: " + average); //prints the average of one row of the array  
	}
}
