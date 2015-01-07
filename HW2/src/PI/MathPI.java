package PI;
import java.util.*;

/**
 * 
 * @author Joseph
 *
 */

public class MathPI {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		/**
		 * Gets how far the user wants to go in the series
		 */
		System.out.printf("How far do you want to go into the series? ");
		int resp = scan.nextInt();
		
		/**
		 * calls the static method from the CalculatePI class
		 */
		double pi = CalculatePI.calcPI(resp);
		
		/**
		 * Prints out the result of the calculation
		 */
		System.out.printf("PI to the " + resp + " is " + pi + "\n");
		
		/**
		 * closes the scanner
		 */
		scan.close();
	}
}
