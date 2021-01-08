package at.aau.ue3.bsp2;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.function.Function;

import static org.junit.Assert.*;

//Wetscher Nicolas 11845621
public class RelationCheckerTest {
    //TODO fill tests

	@Test
	public void test(){

		assertEquals(10,RelationChecker.checkRelation(4,5));
		//assertEquals(40,RelationChecker.checkRelation(15,13));
		//Function<String, String> a = (String s) -> s + s;
		ThrowingRunnable runnable = () -> {RelationChecker.checkRelation(15,13);};
		assertThrows(java.lang.ArithmeticException.class, runnable);
	}

	@Test
	public void pfadtest(){
		assertEquals(10,RelationChecker.checkRelation(4,5));
		assertEquals(9,RelationChecker.checkRelation(5,4));
		assertEquals(40,RelationChecker.checkRelation(20,30));
		assertThrows(java.lang.ArithmeticException.class, () -> {RelationChecker.checkRelation(15,13);});
	}
}
