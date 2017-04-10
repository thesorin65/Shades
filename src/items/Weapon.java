package items;

import java.awt.image.BufferedImage;

public class Weapon{

	public Weapon(int att, String name, int cost, BufferedImage image)
	{
		this.setAtt(att);
		this.setName(name);
		this.setCost(cost);
		this.setImage(image);
	}
	
	public int getAtt() {
		return att;
	}
	
	public void setAtt(int att) {
		this.att = att;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	private int att;
	private String name;
	private int cost;
	private BufferedImage image;
	
}
