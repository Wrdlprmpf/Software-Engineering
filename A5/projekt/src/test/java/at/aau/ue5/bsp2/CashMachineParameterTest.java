package at.aau.ue5.bsp2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;

public class CashMachineParameterTest {

    private CashMachine cashMachine;

    @ParameterizedTest
    @ValueSource(strings = {"1234", "3458", "42","9242022", "42421", "03430300"})
    public void shouldReturnTrue_WhenNotEndingWith42(String number){
        cashMachine.insertCard(number);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.CARD_INSERTED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12342", "345842", "42","9242042", "4242142", "034342030042"})
    public void shouldReturnTrue_WhenEndingWith42(String number){
        cashMachine.insertCard(number);
        assertTrue(cashMachine.getCurrentState()==CashMachineState.CARD_RETAINED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234"})
    public void shouldReturnTrue_WhenPinIs1234(String pin){
        insertValidCard();
        cashMachine.inputPIN(pin);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_OK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12344", "23344"})
    public void shouldReturnTrue_WhenPinIsWrong(String pin){
        insertValidCard();
        cashMachine.inputPIN(pin);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.PIN_NOT_OK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12344", "23344", "123123", "382132"})
    public void shouldReturnTrue_WhenPinCountIsOver3(String pin){
        insertValidCard();
        cashMachine.inputPIN(pin);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_RETAINED);
    }

    @ParameterizedTest
    @ValueSource(ints = {50,20,100,250,1000,10})
    public void shouldReturnTrue_WhenAmountIsCorrect(int cash){
        insertValidCard();
        inputValidPin();
        cashMachine.selectAmount(cash);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_VALID);
    }

    @ParameterizedTest
    @ValueSource(ints = {55,9,99,269,1011,1})
    public void shouldReturnTrue_WhenAmountIsNotValid(int cash){
        insertValidCard();
        inputValidPin();
        cashMachine.selectAmount(cash);
        assertTrue(cashMachine.getCurrentState() == CashMachineState.AMOUNT_NOT_VALID);
    }

    @ParameterizedTest
    @ValueSource()
    public void shouldReturnTrue_WhenCashIsTaken(){
        insertValidCard();
        inputValidPin();
        inputValidAmount();
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CASH_GIVEN);
    }

    @ParameterizedTest
    @ValueSource()
    public void shouldReturnTrue_WhenCardIsRemoved(){
        insertValidCard();
        inputValidPin();
        insertValidCard();
        tookCash();
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState() == CashMachineState.CARD_TAKEN);
    }

    private void insertValidCard(){
        cashMachine.insertCard("12345");
    }

    private void inputValidPin(){
        cashMachine.inputPIN("1234");
    }

    private void inputValidAmount(){
        cashMachine.selectAmount(10);
    }

    private void tookCash(){
        cashMachine.takeCash();
    }
}
