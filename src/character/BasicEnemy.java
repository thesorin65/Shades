package character;

public class BasicEnemy extends Character{

	public BasicEnemy(int x, int y, int maxHealth, int att, int def, String name)
	{
		super(x,y);
		setWalkable(false);
		this.setMaxHealth(maxHealth);
		this.setAtt(att);
		this.setDef(def);
		this.setName(name);
		//set image
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void move()
	{
		
	}

	private int maxHealth;
	private int att;
	private int def;
	private String name;
}
