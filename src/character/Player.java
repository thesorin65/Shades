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
		//equip = new Weapon(1,"Rusty Sword",0,ImageIO.read(new File("File name of rusty sword")));
	}
	
	private int maxHealth = 10;
	private int health;
	private int att = 1;
	private int def = 1;
	private int mana;
	private int lvl;
	private int exp;
	private Weapon equip;
	
	public void setStats(int maxHP, int att, int def, int mana, int lvl, int exp)
	{
		this.maxHealth=maxHP;
		this.att=att;
		this.def=def;
		this.mana=mana;
		this.lvl=lvl;
		this.exp=exp;
	}
	
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

	public Weapon getEquip() {
		return equip;
	}

	public void setEquip(Weapon equip) {
		this.equip = equip;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}
