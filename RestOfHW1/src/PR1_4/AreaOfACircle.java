package PR1_4;
import java.util.*;

/**
 * Calculates the area of a circle from a given radius
 * @author Joseph
 *
 */

public class AreaOfACircle 
{
	/**
	 * member variables for the equation for the area of a circle
	 */
	final public static double PI = 3.14;
	public static double radius;
	public static double area;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		/**
		 * gets the radius of the user's circle
		 */
		System.out.printf("Enter the radius of your circle: ");
		radius = input.nextDouble();
		
		/**
		 * computes the area of the user's circle
		 */
		System.out.println("The area of your circle is " + PI * radius * radius + 
				" in whatever units you are using.");
		
		input.close();
	}
}