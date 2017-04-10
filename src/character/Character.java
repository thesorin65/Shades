package character;

import java.awt.image.BufferedImage;

public class Character {
	public Character(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
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

	public boolean getWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

	private BufferedImage image;
	private int x;
	private int y;
	private boolean walkable;
}
