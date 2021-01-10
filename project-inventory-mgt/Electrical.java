package ServerPackage;

public class Electrical extends Tool {
	public Electrical(int Id, String name, int quantity, double price, int supId) {
		super(Id, name, quantity, price, supId);
		// TODO Auto-generated constructor stub
	}
	Tool supply;
	private String powerType;
	
	
	public void setPowerType() {
		this.powerType = powerType;
	
	}
	
	public String getPowerType() {
		return powerType;
	}
	
	
	
}
