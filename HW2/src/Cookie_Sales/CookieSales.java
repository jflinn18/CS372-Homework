package Cookie_Sales;

public class CookieSales {
	
	private int _totalSales = 0;
	private int _samoaCount = 0;
	private int _thinMintsCount = 0;
	private int _chocolateChipCount = 0;
	
	public void addSales(int s, int t, int c)
	{
		setTotal(s * 4);
		setTotal(t * 3);
		setTotal(c * 5);
		
		setSamoaCount(s);
		setThinMintsCount(t);
		setChocolateChipCount(c);
	}
	
	public void setTotal(int total) { _totalSales += total; }
	public void setSamoaCount(int i) { _samoaCount += i; }
	public void setThinMintsCount(int i) { _thinMintsCount += i; }
	public void setChocolateChipCount(int i) { _chocolateChipCount += i; }
	
	public int getTotal() { return _totalSales; }
	public int getSamoaCount() { return _samoaCount; }
	public int getThinMintsCount() { return _thinMintsCount; }
	public int getChocolateCount() { return _chocolateChipCount; }
}