package ShapeClassHierarchy;

public class Ellipse extends Shape{
	
	private double _rad1;
	private double _rad2;

	/**
	 * Ellipse Constructor
	 * @param r1
	 * @param r2
	 * @throws IllegalArgumentException
	 */
	public Ellipse(int r1, int r2) throws IllegalArgumentException
	{
		if(r1 == 0 || r2 == 0)
			throw new IllegalArgumentException("This is not an Ellipse");
		
		_rad1 = r1;
		_rad2 = r2;
	}
	
	/**
	 * Calculate the area of an ellipse
	 */
	@Override
	public double getArea() { return Math.PI * _rad1 * _rad2; }
	/**
	 * Calculate the perimeter of an ellipse
	 * This is an approximation since it is very hard to calculate the actual perimeter of the ellipse
	 */
	@Override
	public double getPerimeter() { return 2 * Math.PI * (Math.sqrt(Math.pow(_rad1, 2) + Math.pow(_rad2, 2)) / 2);}
}
