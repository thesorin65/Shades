package map;
import character.*;
import character.Character;

public class Base {

	public Base()
	{
		base = new Character[7][7];
		
		for(int x = 0;x<base.length;x++)
		{
			for(int y = 0;y<base[0].length;y++)
			{
				base[x][y] = new Character(x,y);
			}
		}
		for(int x = 1;x<base.length-1;x++)
		{
			for(int y = 1;y<base[0].length-1;y++)
			{
				base[x][y] = new Empty(x,y);
			}
		}
		
		base[3][0] = new Empty(3,0);
		base[0][3] = new Empty(0,3);
		
		base[5][1] = new Shopkeeper(5,1);
		base[1][1] = new Blacksmith(1,1);
	}
	
	private Character[][] base;
	
	public Character[][] getBase()
	{
		return base;
	}
	
	public void setBase(Character[][] base)
	{
		this.base = base;
	}
}
