package map;
import character.*;
import character.Character;

public class HomeRoom {

	public HomeRoom()
	{
		for(int x = 0;x<room.length;x++)
		{
			for(int y = 0;y<room[x].length;y++)
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
		room[6][3] = new Empty(6,3);
	}
	
	Character[][] room = new Character[7][7];
	
	public Character[][] getRoom()
	{
		return room;
	}
	
	public void setRoom(Character[][] room)
	{
		this.room = room;
	}
}
