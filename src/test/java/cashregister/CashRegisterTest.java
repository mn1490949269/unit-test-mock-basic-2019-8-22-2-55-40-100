package cashregister;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.concurrent.DetachedThreadLocal.Cleaner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
	private static  MockPrinter mockPrinter;
	private static CashRegister cashRegister;
	
	@BeforeAll
	private static void setup() {
		mockPrinter = new MockPrinter();
		cashRegister = new CashRegister(mockPrinter);
	}
	
	@BeforeEach
	public void Clear() {
		mockPrinter.setTextString("");
	}

	


    @Test
    //@Disabled
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item[] items = {new Item("food", 3) };
    	Purchase purchase = new Purchase(items);

        //when
    	
    	cashRegister.process(purchase);
        //then
    	assertEquals("food\t3.0\n", mockPrinter.getTextString());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
    	StubPurchase stubPurchase = new StubPurchase();
    	
        //when
    	cashRegister.process(stubPurchase);
        //then
    	assertEquals("food\t3.0\n", mockPrinter.getTextString());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
    	Printer printer = Mockito.mock(Printer.class);
    	Purchase purchase = Mockito.mock(Purchase.class);
    	Mockito.when(purchase.asString()).thenReturn("food\t3.0\n");
        //when
    	CashRegister cashRegister = new CashRegister(printer);
    	cashRegister.process(purchase);
        //then
    	Mockito.verify(printer).print("food\t3.0\n");
    }

}
