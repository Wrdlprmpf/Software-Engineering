import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EinsteigsbeispielTest {
	@Test
	public void WhenEnteringTwoOnesAndTwoTwos_ThenExpectTwoTwos(){
		int[] testarr = new int[]{1,1,2,2,};

		Map<Integer, Integer> tester = Einstiegsbeispiel.getRepetitions(testarr);

		assertEquals(3,(int)tester.get(1),"Test failed succesfully");


	}
}
