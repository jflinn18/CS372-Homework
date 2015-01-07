package PI;

/**
 * Prints out a table of different accuracies of pi.
 * @author Joseph
 *
 */

public class MathPI {

	public static void main(String[] args)
	{
		String argument = "";
		
		if (args.length > 0)
			argument = args[0];
		
		int times;
		times = Integer.parseInt(argument);
		
		/**
		 * calls the static method from the CalculatePI class
		 */
		double pi = CalculatePI.calcPI(times);
		
		/**
		 * Prints out the table of resulting calculations
		 */
		
		for (int i = 0; i < times; i++)
		{
			pi = CalculatePI.calcPI(times);
			System.out.printf("PI to the " + times + " is " + pi + "\n");
		}

	}
}