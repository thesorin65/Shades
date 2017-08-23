package character;

import java.awt.image.BufferedImage;
import java.util.TreeMap;

public class Unit {
	public Unit(int x, int y)
	{
		this.setX(x);
		this.setY(y);
		images = new TreeMap<String,BufferedImage>();
	}
	
	public BufferedImage getImage(String key)
	{
		return images.get(key);
	}
	
	public void addImage(String key, BufferedImage img)
	{
		images.put(key, img);
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
}
