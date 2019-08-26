package cashregister;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        //when
        //then
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        //when
        //then
    }

}
