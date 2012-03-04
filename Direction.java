public class Direction
{
	public static final int UP = 0;
	public static final int LEFT = 90;
	public static final int DOWN = 180;
	public static final int RIGHT = 270;
	
	public int direction;
	
	public Direction(int dir)
	{
		if(dir % 90 == 0 || dir % 90 == 90)
			direction = dir;
		else
			direction = 0;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	//PRE-CONDITION: int direction equals 0 or is a multiply of 90, where ( direction <= 270 && direction >= 0 )
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
}