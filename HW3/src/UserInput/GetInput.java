package UserInput;
import java.util.*;

public class GetInput {
	
	private ArrayList<Integer> list = new ArrayList<Integer>();

	private int _min;
	private int _max;
	private double _ave;
	
	/**
	 * Constructor
	 */
	public GetInput()
	{
		_min = Integer.MAX_VALUE;
		_max = 0;
		_ave = 0;
		
		run();
		
		
		System.out.println(toString());
	}
	
	/**
	 * Gets the data from the user and handles any input exception
	 */
	public void run()
	{
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 10; i ++)
		{
			try 
			{
				//PT -- generally try to separate the UI from the logic. So I would expect this
				//      code in UserInput.java -2
				System.out.print("Enter an integer: ");
				list.add(scan.nextInt());
			}
			catch (Exception e)
			{
				System.out.println("You did not enter an integer.");
				scan.nextLine();
				i--;
			}
		}
		
		scan.close();
		
		
	}
		
	
	/**
	 * Sets the member variables from the user's data
	 */
	public void setMembers()
	{
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) > _max)
			{
				setMax(list.get(i));
			}
			
			if (list.get(i) < _min)
			{
				setMin(list.get(i));
			}
			
			sum += list.get(i);
		}
		
		setAverage(sum / list.size());
	}
	
	/**
	 * Overrides the toString method in the Object class and formats the data into a string to be output
	 */
	@Override
	public String toString()
	{
		return String.format("The smallest number entered is %d\nThe biggest number entered is %d\n The average of the numbers is %f",
				getMin(), getMax(), getAverage());
	}
	
	/**
	 * Get function for member variable _min
	 * @return
	 */
	public int getMin() { return _min; }
	/**
	 * Get function for member variable _max
	 * @return
	 */
	public int getMax() { return _max; }
	/**
	 * Get function for member variable _ave
	 * @return
	 */
	public double getAverage() { return _ave; }
	
	
	/**
	 * Set function for _min
	 * @param min
	 */
	public void setMin(int min) { _min = min; }
	/**
	 * Set function for _max
	 * @param max
	 */
	public void setMax(int max) { _max = max; }
	/**
	 * Set function for _ave
	 * @param average
	 */
	public void setAverage(double average) { _ave = average;}
	
}
