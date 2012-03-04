public class Asteroid extends GameObject
{
	private int size;
	
	
	public Asteroid(Grid grid, Location loc, int size)
	{
		super(grid, loc, size * 25, size * 20);
		
		this.size = size;
	}
	
	public boolean canMove(Location loc)
	{
		if(this.getGrid().isValidLocation(this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.DOWN))))
		{
			return true;
		}
		return false;
	}
	
	public void split()
	{
		
		Location right = this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.RIGHT));
		Location left = this.getGrid().getAdjacentLocationTowards(this.getObjLocation(), new Direction(Direction.LEFT));
		
		if(this.getGrid().isValidLocation(right) && this.getGrid().isValidLocation(left) && right.getObj() == null && left.getObj() == null)
		{
			Asteroid a1 = new Asteroid(this.getGrid(), right, this.size - 1);
			Asteroid a2 = new Asteroid(this.getGrid(), left, this.size - 1);
			a1.putSelfInGrid();
			a2.putSelfInGrid();
			this.removeSelfFromGrid();
		}
		else if((right.getObj() != null || !getGrid().isValidLocation(right)) && this.getGrid().isValidLocation(left) && left.getObj() == null)
		{
			Asteroid a1 = new Asteroid(this.getGrid(), left, this.size - 1);
			Asteroid a2 = new Asteroid(this.getGrid(), this.getObjLocation(), this.size - 1);
			a1.putSelfInGrid();
			a2.putSelfInGrid();
			//this.removeSelfFromGrid();
		}
		else if((left.getObj() != null || !getGrid().isValidLocation(left)) && this.getGrid().isValidLocation(right) && right.getObj() == null)
		{
			Asteroid a1 = new Asteroid(this.getGrid(), right, this.size - 1);
			Asteroid a2 = new Asteroid(this.getGrid(), this.getObjLocation(), this.size - 1);
			a1.putSelfInGrid();
			a2.putSelfInGrid();
			//this.removeSelfFromGrid();
		}
		else
		{
			Asteroid a1 = new Asteroid(this.getGrid(), this.getObjLocation(), this.size - 1);
			a1.putSelfInGrid();
			//this.removeSelfFromGrid();
		}
	}
}