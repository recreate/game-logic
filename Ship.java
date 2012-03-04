public class Ship extends GameObject
{
	private int numLives;
	
	
	public Ship(Grid grid, Location loc, int points, int hp, int lives)
	{
		super(grid, loc, points, hp);
		this.numLives = lives;
	}
	
	public int getNumLives()
	{
		return this.numLives;
	}
	
	public boolean canMove(Location loc)
	{
		boolean isAnAdjacentLoc = false;
		for(Location L1: this.getGrid().getAdjacentLocations(this.getObjLocation()))
		{
			if(Location.isEqual(loc, L1))
				isAnAdjacentLoc = true;
		}
		
		if(isAnAdjacentLoc)
		{
			if(Location.isEqual(this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.LEFT)), loc))
				return true;
			if(Location.isEqual(this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.RIGHT)), loc))
				return true;
		}
		return false;
		
	}
	
	public void fireLaser()
	{
		Laser L1 = new Laser(this.getGrid(), this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.UP)));
		L1.putSelfInGrid();
	}
	
}