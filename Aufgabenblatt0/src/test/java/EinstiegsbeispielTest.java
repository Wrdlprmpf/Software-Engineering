import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EinstiegsbeispielTest {

	@Test
	public void WhenEnteringTwoOnesAndTwoTwos_ThenExpectTwoTwos(){
		int[] testArr = new int[]{1,1,2,2};

		Map<Integer, Integer> tester = Einstiegsbeispiel.getRepetitions(testArr);

		assertEquals(2,(int)tester.get(1),"Test failed succesfully");



	}

	@Test
	public void WhenEnteringTwoFoursAndSixFives_ThenExpectTwoAndSix(){
		int[] testArr2 = new int[]{4,4,5,5,5,5,5,5};

		Map<Integer, Integer> tester2 = Einstiegsbeispiel.getRepetitions(testArr2);

		assertEquals(3,(int)tester2.get(2),"Test2 failed misserably");

	}

	@Test
	public void WhenEnteringNothing_ThenExpectError(){
		
	}
}
