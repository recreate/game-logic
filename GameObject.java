public abstract class GameObject
{
	private int pointValue;
	private Grid grid;
	private Location objLoc;
	private int hitPoints;
	
	public GameObject(Grid grid, Location loc, int points, int hp)
	{
		this.grid = grid;
		this.objLoc = loc;
		this.pointValue = points;
		this.hitPoints = hp;
	}
	
	public int getPointValue()
	{
		return pointValue;
	}
	
	public void setPointValue(int p)
	{
		this.pointValue = p;
	}
	
	public int getHitPoints()
	{
		return hitPoints;
	}
	
	public void setHitPoints(int hp)
	{
		this.hitPoints = hp;
	}
	
	
	public Grid getGrid()
	{
		return this.grid;
	}
	
	public Location getObjLocation()
	{
		return this.objLoc;
	}
	public void setObjLocation(Location loc)
	{
		this.objLoc = loc;
	}
	
	public void putSelfInGrid()
	{
		this.getGrid().putObj(this);
	}
	
	public void removeSelfFromGrid()
	{
		this.getGrid().removeObj(this.objLoc);
	}
	
	public void MoveTo(Location loc)
	{
		if(this.canMove(loc))
		{
			this.setObjLocation(loc);
			this.getGrid().removeObj(this.getObjLocation());
			this.getGrid().putObj(this);
		}
	}
	
	public abstract boolean canMove(Location loc);
	
}