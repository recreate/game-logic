public class Laser extends GameObject
{
	
	public Laser(Grid grid, Location loc)
	{
		super(grid, loc, 0, 0);
		//0 points, 0 hp
	}
	
	public boolean canMove(Location loc)
	{
		if(this.getGrid().isValidLocation(this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.UP))))
		{
			return true;
		}
		return false;
	}
	
}