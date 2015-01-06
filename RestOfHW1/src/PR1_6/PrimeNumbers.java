package PR1_6;
import java.util.*;

public class PrimeNumbers {

	public static void main(String[]  args)
	{
		/**
		 * create new scanner object
		 */
		Scanner input = new Scanner(System.in);


		/**
		 * Ask the user for an upper bound
		 */
		System.out.printf("Enter the upper bound: ");
		int upperbound = input.nextInt();
		
		
		/**
		 * According to Wikipedia (I know its not the best source), 1 can be considered a 
		 * prime, however, including it as a prime will not let some theorems work. So I 
		 * have excluded it from my program. And I couldn't get the algorithm to work to 
		 * print out 1 as a prime. 
		 * 
		 * System.out.println("1 is a prime.");
		 */
		
		
		/**
		 * Check all of the numbers between 2 and the upper bound to see if dividing it 
		 * will yield another factor other than one and itself
		 */
		for (int i = 2; i <= upperbound; i++)
		{
			/**
			 * start with 2 because everything can be divided by 1
			 */
			for (int j = 2; j <= i; j++) 
			{
				/**
				 * if j iterates through until it equals i without moding and equalling 0,
				 * j is a prime number
				 */
				if (i == j)
				{
					System.out.println(i + " is a prime.");
					continue; // stop checking this number
				}
				if (i % j == 0)
					break;
			}
		}
		
		/**
		 * Tells the system that it is done
		 */
		System.out.println("Done...................\n");
		


		/**
		 * Close input. 
		 */
		input.close();
	}
}
