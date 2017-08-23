package map;

import java.awt.image.BufferedImage;

public class MapEntity
{
	public MapEntity(int x, int y, BufferedImage image, String name)
	{
		this.x = x;
		this.y = y;
		this.image = image;
		this.name = name;
	}

	private int x;
	private int y;
	private BufferedImage image;
	private String name;
	
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public BufferedImage getImage()
	{
		return image;
	}
	public void setImage(BufferedImage image)
	{
		this.image = image;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
