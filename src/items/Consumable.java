package items;

public class Consumable{

	public Consumable(int cost, String name, String effect)
	{
		this.setCost(cost);
		this.setName(name);
		this.setEffect(effect);
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	private int cost;
	private String name;
	private String effect;
}
