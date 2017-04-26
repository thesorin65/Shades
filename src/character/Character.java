package character;

import java.awt.image.BufferedImage;
import java.util.TreeMap;

public class Character {
	public Character(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	public BufferedImage getImage(String key)
	{
		return images.get(key);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private TreeMap<String, BufferedImage> images;
	private int x;
	private int y;
	private boolean walkable;
}
