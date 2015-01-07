package PR1_5;
import java.util.*;

/**
 * Picks 25 random integers and prints if all of them are greater, less, or equal to the 
 * second one.
 * @author Joseph
 *
 */

public class RandomNumbers {

	public static void main(String[] args)
	{
		/**
		 * Creates a Random object from the java.util package
		 */
		Random gen = new Random();
		
		/**
		 * Creates an empty array of 25 integers to be filled with random ints
		 */
		int[] nums = new int[25];
		
		/**
		 * Fills the array with random integers, no constraint.
		 * Used the .length member so that if I needed to change the length of the array, 
		 * I would only be changing one number instead of three.
		 */
		for (int i = 0; i < nums.length; i++)
			nums[i] = gen.nextInt();
		
		/**
		 * Prints out the each number and if it is greater than the second randomly chosen int
		 * It skips the comparison of the the index 1 of the array. This would compare the 
		 * same number with itself. 
		 * 
		 * The int counters were out of curiosity. I also changed the 25 to 1000000 to see if the 
		 * percentage was different. 
		 */
		
		double greater = 0;
		double less = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			if (i == 1)
				continue; // skips the second randomly chosen int
			else if (nums[i] < nums[1])
			{
				System.out.printf("%d is less than %d\n", nums[i], nums[1]);
				less++; // extra
			}
			else if (nums[i] > nums[1])
			{
				System.out.printf("%d is greater than %d\n", nums[i], nums[1]);
				greater++; // extra
			}
			else
				System.out.printf("%d is equal to %d\n", nums[i], nums[1]);
		}
		
		
		System.out.printf("Less => %f\nGreater => %f\n", less / nums.length, greater / nums.length);
		
		
	}
}
