package PI;

/**
 * Calculates PI to a given accuracy using a given equation
 * @author Joseph
 *
 */

public class CalculatePI {

	public static double PI;
	
	public static double calcPI(int times)
	{
		for (int i = 1; i <= times; i++)
		{
			/**
			 * If i is even, subtract the value from PI
			 * converts to double instead of doing integer division
			 */
			if (i % 2 == 0)
				PI -= (double)4 / (double)(i+(i-1)); 
			/**
			 * If i is odd, add the value to PI
			 * converts to double instead of doing integer division
			 */
			else
				PI += (double)4 / (double)(i+(i-1));
		}
		
		return PI;
	}
}
