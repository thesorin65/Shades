package character;
import items.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Character{
	
	public Player(int x,int y)
	{
		super(x,y);
		setWalkable(false);
		inBase = true;
		inHome = false;
		inDungeon1 = false;
		inDungeon2 = false;
		lvl = 1;
		int lvls = 4;
		while(lvls>0)
		{
			double ran = Math.random();
			if(ran<0.3)
			{
				att++;
			}
			else if(ran<0.6)
			{
				def++;
			}
			else
			{
				maxHealth+=10;
			}
			lvls--;
		}
		health = maxHealth;
		setExp(0);
		//add image
		//equip = new Weapon(1,"Rusty Sword",0,ImageIO.read(new File("File name of rusty sword")));
	}
	
	private int maxHealth = 20;
	private int health;
	private int att = 2;
	private int def = 2;
	private int mana;
	private int lvl;
	private int exp;
	private BufferedImage image;
	private Weapon equip;
	private Consumable[] consumables = new Consumable[10];
	private boolean inBase;
	private boolean inHome;
	private boolean inDungeon1;
	private boolean inDungeon2;
	
	public void takeDamage(int damage)
	{
		health -= (damage-def);
	}
	
	public void gainExp(int exp)
	{
		this.setExp(this.getExp() + exp);
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public int getAtt()
	{
		return att;
	}
	
	public int getDef()
	{
		return def;
	}
	
	public int getMana()
	{
		return mana;
	}

	public int getLvl()
	{
		return lvl;
	}
	
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void setAtt(int att)
	{
		this.att = att;
	}
	
	public void setDef(int def)
	{
		this.def = def;
	}
	
	public void setMana(int mana)
	{
		this.mana = mana;
	}

	public void setLvl(int lvl)
	{
		this.lvl = lvl;
	}
	
	public void lvlUp()
	{
		if(lvl!=10)
		{
			lvl++;
			mana++;
			maxHealth+=10;
			att++;
			def++;
			
			double ran = Math.random();
			
			if(ran<0.4)
			{
				maxHealth+=10;
			}
			else if(ran<0.7)
			{
				att++;
			}
			else if(ran<1)
			{
				def++;
			}
			health=maxHealth;
		}
	}
	
	public void lvlUp(boolean h, boolean a, boolean d)
	{
		if(lvl!=10)
		{
			lvl++;
			mana++;
			maxHealth+=10;
			att++;
			def++;
			
			if(h)
			{
				maxHealth+=10;
			}
			else if(a)
			{
				att++;
			}
			else if(d)
			{
				def++;
			}
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Consumable[] getConsumables() {
		return consumables;
	}

	public void setConsumables(Consumable[] consumables) {
		this.consumables = consumables;
	}

	public Weapon getEquip() {
		return equip;
	}

	public void setEquip(Weapon equip) {
		this.equip = equip;
	}

	public boolean getInBase() {
		return inBase;
	}

	public void setInBase(boolean inBase) {
		this.inBase = inBase;
	}

	public boolean getInHome() {
		return inHome;
	}

	public void setInHome(boolean inHome) {
		this.inHome = inHome;
	}

	public boolean getInDungeon1() {
		return inDungeon1;
	}

	public void setInDungeon1(boolean inDungeon1) {
		this.inDungeon1 = inDungeon1;
	}

	public boolean getInDungeon2() {
		return inDungeon2;
	}

	public void setInDungeon2(boolean inDungeon2) {
		this.inDungeon2 = inDungeon2;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}
