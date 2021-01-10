package ServerPackage;

public class internationalSupplier extends Supplier {
	Tool tool;
	private double importTax;
	public internationalSupplier(int id, String name, String address, String sales) {
		super(id, name, address, sales);
		// TODO Auto-generated constructor stub
	}

	public double importTax() {
		importTax = tool.getToolPrice()*0.05;
	return importTax;
	}
    

	
}
