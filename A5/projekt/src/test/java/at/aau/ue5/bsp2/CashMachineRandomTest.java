package at.aau.ue5.bsp2;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashMachineRandomTest {
    private CashMachine[] cashMachines = new CashMachine[10000];

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
}
