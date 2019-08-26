package cashregister;

public class MockPrinter extends Printer{
	private String textString = "";
	public void setTextString(String string) {
		this.textString = string;
	}
	public String getTextString() {
		return textString;
	}
	public void print(String printThis) {
		super.print(printThis);;
	    textString = printThis;
		
	}
}
