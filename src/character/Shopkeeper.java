package character;

public class Shopkeeper extends Character{

	public Shopkeeper(int x, int y)
	{
		super(x,y);
		setName(new String[NUM_OF_ITEMS]);
		setCost(new int[NUM_OF_ITEMS]);
		setSellPrice(new int[NUM_OF_ITEMS]);
		setInStock(new boolean[NUM_OF_ITEMS]);
		//image
	}
	
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}

	public int[] getCost() {
		return cost;
	}

	public void setCost(int[] cost) {
		this.cost = cost;
	}

	public int[] getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int[] sellPrice) {
		this.sellPrice = sellPrice;
	}

	public boolean[] getInStock() {
		return inStock;
	}

	public void setInStock(boolean[] inStock) {
		this.inStock = inStock;
	}

	private String[] name;
	private int[] cost;
	private int[] sellPrice;
	private boolean[] inStock;
	public static final int NUM_OF_ITEMS = 10;
	
	public void addItem(String name, int cost, int sellPrice, boolean inStock, int pos)
	{
		this.name[pos] = name;
		this.cost[pos] = cost;
		this.sellPrice[pos] = sellPrice;
		this.inStock[pos] = inStock;
	}
}