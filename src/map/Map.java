package map;

public class Map {

	public Map()
	{
		createMap();
	}
	
	public Room[][] getMap() {
		return map;
	}
	public void setMap(Room[][] map) {
		this.map = map;
	}
	
	public void createMap()
	{
		for(int x = 0;x<map.length;x++)
		{
			for(int y = 0;y<map.length;y++)
			{
				map[x][y] = new Room(2,2,2,2);
			}
		}
	}
	

	public static final int size = 5;
	private Room[][] map = new Room[size][size];

}
