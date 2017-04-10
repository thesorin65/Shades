package map;
import character.*;
import character.Character;

public class Room {

	public Room(int left, int right, int up, int down)
	{
		createRoom(left, right, up, down);
	}
	
	private boolean hasExit = false;
	private Character[][] room = new Character[7][7];
	
	public boolean getHasExit()
	{
		return hasExit;
	}
	
	public void setHasExit(boolean hasExit)
	{
		this.hasExit = hasExit;
	}

	public Character[][] getRoom() {
		return room;
	}

	public void setRoom(Character[][] room) {
		this.room = room;
	}
	
	public boolean hasPlayer()
	{
		for(int x = 0;x<room.length;x++)
		{
			for(int y = 0;y<room[0].length;y++)
			{
				if(room[x][y] instanceof Player)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	//0 = random, 1 = not walkable, 2 = walkable
	public void createRoom(int left, int right, int up, int down)
	{
		
		for(int x = 0;x<room.length;x++)
		{
			for(int y = 0;y<room.length;y++)
			{
				room[x][y] = new Character(x,y);
			}
		}
		
		for(int x = 1;x<room.length-1;x++)
		{
			for(int y = 1;y<room[0].length-1;y++)
			{
				room[x][y] = new Empty(x,y);
			}
		}
		
		boolean l = true;
		boolean r = true;
		boolean u = true;
		boolean d = true;
		
		do
		{
			double ran = Math.random();
			
			if(ran<0.5&&left==0)
			{
				l = false;
			}
			else if(left == 1)
			{
				l = false;
			}

			ran = Math.random();
			if(ran<0.5&&right==0)
			{
				r = false;
			}
			else if(right ==1)
			{
				r=false;
			}

			ran = Math.random();
			if(ran<0.5&&up==0)
			{
				u = false;
			}
			else if(up == 1)
			{
				u = false;
			}

			ran = Math.random();
			if(ran<0.5&&down==0)
			{
				d = false;
			}
			else if(down ==1)
			{
				d=false;
			}
		}while(l==false&&u==false&&r==false&&d==false);

		if(l)
		{
			room[0][3] = new Empty(0,3);
		}
		if(u)
		{
			room[3][0] = new Empty(3,0);
		}
		if(r)
		{
			room[6][3] = new Empty(6,3);
		}
		if(d)
		{
			room[3][6] = new Empty(3,6);
		}
	}
}
