package character;

public class Projectile extends Unit implements Runnable
{
	public Projectile(int x, int y)
	{
		super(x, y);
		new Thread(this).start();
	}
	
	public int getDmg()
	{
		return dmg;
	}

	public void setDmg(int dmg)
	{
		this.dmg = dmg;
	}

	private int dmg;

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(7);
				update();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void update()
	{
		if(getDirection()==Unit.UP)
			setY(getY() - 3);
		if(getDirection()==Unit.LEFT)
			setX(getX() - 3);
		if(getDirection()==Unit.DOWN)
			setY(getY() + 3);
		if(getDirection()==Unit.RIGHT)
			setX(getX() + 3);
	}
}
