package character;

import java.awt.image.BufferedImage;

public class Wall extends Character{

	public Wall(int x, int y)
	{
		super(x,y);
		setWalkable(false);
		//try catch for image
	}
}
