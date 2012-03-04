import java.util.ArrayList;

public class Grid
{
	private Location[][] grid;
	
	public Grid(int length, int width)
	{
		
		grid = new Location[length][];
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < width; j++)
			{
				grid[i][j] = new Location(i, j);
			}
		}
	}
	
	public int getLength()
	{
		return grid.length;
	}
	public int getWidth()
	{
		return grid[this.getLength() - 1].length;
	}
	
	public Location getLocation(int x, int y)
	{
		return grid[x][y];
	}
	
	public void putObj(GameObject obj)
	{
		grid[obj.getObjLocation().getXCoord()][obj.getObjLocation().getYCoord()].setObj(obj);
	}
	
	public Object removeObj(Location loc)
	{
		Object returnObj = grid[loc.getXCoord()][loc.getYCoord()].getObj();
		grid[loc.getXCoord()][loc.getYCoord()].setObj(null);
		return returnObj;
	}
	
	public boolean isValidLocation(Location loc)
	{
		if(loc.getXCoord() < 0 || loc.getXCoord() > this.getWidth())
			return false;
		if(loc.getYCoord() < 0 || loc.getYCoord() > this.getLength())
			return false;
		else
			return true;
	}
	
	public ArrayList<Location> getAdjacentLocations(Location loc)
	{
		ArrayList<Location> adjacentLocs = new ArrayList<Location>();
		for(int i = loc.getXCoord() - 1; i < loc.getXCoord() + 1; i++)
		{
			for(int j = loc.getYCoord() + 1; j < loc.getYCoord() - 1; i++)
			{
				if(this.isValidLocation(this.getLocation(i, j)) 
					&& i != this.getLocation(i, j).getXCoord() && j != this.getLocation(i, j).getYCoord())
				{
					adjacentLocs.add(this.getLocation(i, j));
				}
			}
		}
		return adjacentLocs;
	}
	
	public Location getAdjacentLocationTowards(Location loc, Direction dir)
	{
		if(dir.getDirection() == Direction.UP)
		{
			if(this.isValidLocation(this.getLocation(loc.getXCoord(), loc.getYCoord() + 1 )))
				return this.getLocation(loc.getXCoord(), loc.getYCoord() + 1);
		}
		else if(dir.getDirection() == Direction.LEFT)
		{
			if(this.isValidLocation(this.getLocation(loc.getXCoord() - 1, loc.getYCoord() )))
				return this.getLocation(loc.getXCoord() - 1, loc.getYCoord());
		}
		else if(dir.getDirection() == Direction.DOWN)
		{
			if(this.isValidLocation(this.getLocation(loc.getXCoord(), loc.getYCoord() - 1 )))
				return this.getLocation(loc.getXCoord(), loc.getYCoord() - 1);
		}
		else if(dir.getDirection() == Direction.RIGHT)
		{
			if(this.isValidLocation(this.getLocation(loc.getXCoord() + 1, loc.getYCoord() )))
				return this.getLocation(loc.getXCoord() + 1, loc.getYCoord());
		}
		return new Location(-1, -1, null);
	}
}