public class Location
{
	private int xCoord;
	private int yCoord;
	private Object obj;
	
	public Location(int x, int y)
	{
		xCoord = x;
		yCoord = y;
		obj = null;
	}
	public Location(int x, int y, Object object)
	{
		xCoord = x;
		yCoord = y;
		obj = object;
	}
	
	public int getXCoord()
	{
		return this.xCoord;
	}
	public int getYCoord()
	{
		return this.yCoord;
	}
	public Object getObj()
	{
		return this.obj;
	}
	public void setObj(Object obj)
	{
		this.obj = obj;
	}
	
	public static boolean isEqual(Location loc1, Location loc2)
	{
		if(loc1.getXCoord() == loc2.getXCoord() && loc1.getYCoord() == loc2.getYCoord())
		{
			return true;
		}
		return false;
	}
	
}