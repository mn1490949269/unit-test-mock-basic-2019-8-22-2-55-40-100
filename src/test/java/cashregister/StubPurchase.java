package cashregister;

public class StubPurchase extends Purchase {
	public StubPurchase() {
		super(new Item[0]);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String asString() {
		return "food\t3.0\n";
		// TODO Auto-generated method stub

	}
	

}
