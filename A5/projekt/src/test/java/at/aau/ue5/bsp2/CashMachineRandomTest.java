package at.aau.ue5.bsp2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CashMachineRandomTest {
    private CashMachine[] cashMachines = new CashMachine[10000];
    private CashMachine cashMachine = new CashMachine();

    /*
	@BeforeEach
	public void fillUpCash(){
		for (int i = 0; i < cashMachines.length; i++) {
			cashMachines[i] = new CashMachine();
		}
	}

    @Test
    public void randomTest(){
        for (int i = 0; i < cashMachines.length; i++) {
            cashMachines[i].insertCard("12345");
            cashMachines[i].inputPIN("1234");
            cashMachines[i].selectAmount(10);
            cashMachines[i].takeCash();
            cashMachines[i].removeCard();
        }
    }

    @Test
    public void randomTestWithCardRetain(){
        for (int i = 0; i < cashMachines.length; i++) {
            cashMachines[i].insertCard("12342");
        }
    }

     */

	/** Minimal Sequenz
	 * Start -> Card_Retained
	 */

	// Start - Card_Retained
	@Test
	public void shouldReturnTrue_WhenCardIsRetained(){
		cashMachine.insertCard("1234542");
		assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_RETAINED);
	}

	// Start - PIN_NOT_OK - PIN_NOT_OK - PIN_NOT_OK - CARD_Retained
	@Test
	public void shouldReturnTrue_WhenCardIsRetainedDueToTooManyPinInputs(){
		cashMachine.insertCard("12345");
		cashMachine.inputPIN("123");
		cashMachine.inputPIN("123");
		cashMachine.inputPIN("123");
		assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_RETAINED);
	}

	// Start - PIN_NOT_OK - PIN_OK - AMOUNT_NOT_VALID
	@Test
	public void shouldReturnTrue_WhenAmountNotValid(){
		cashMachine.insertCard("12345");
		cashMachine.inputPIN("123");
		cashMachine.inputPIN("1234");
		cashMachine.selectAmount(122);
		assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_NOT_VALID);
	}

	// Start - PIN_NOT_OK - PIN_OK - AMOUNT_NOT_VALID - AMOUNT_VALID
	@Test
	public void shouldReturnTrue_WhenAmountValid(){
		cashMachine.insertCard("12345");
		cashMachine.inputPIN("123");
		cashMachine.inputPIN("1234");
		cashMachine.selectAmount(122);
		cashMachine.selectAmount(50);
		assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_VALID);
	}

	// Start - PIN_NOT_OK - PIN_OK - AMOUNT_NOT_VALID - AMOUNT_VALID - AMOUNT_NOT_VALID - CASH_GIVEN - CARD_TAKEN
	@Test
	public void shouldReturnTrue_When(){
		cashMachine.insertCard("12345");
		cashMachine.inputPIN("123");
		cashMachine.inputPIN("1234");
		cashMachine.selectAmount(122);
		cashMachine.selectAmount(1982);
		cashMachine.selectAmount(50);
		cashMachine.takeCash();
		cashMachine.removeCard();
		assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_TAKEN);
	}

}
