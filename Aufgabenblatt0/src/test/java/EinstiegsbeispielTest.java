//Wetscher Nicolas 11845621

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EinstiegsbeispielTest {

	@Test
	public void WhenEnteringTwoOnesAndTwoTwos_ThenExpectTwoTwos(){
		int[] testArr = new int[]{1,1,2,2};

		Map<Integer, Integer> tester = Einstiegsbeispiel.getRepetitions(testArr);

		assertEquals(2,(int)tester.get(1),"Test failed");



	}

	@Test
	public void WhenEnteringTwoFoursAndSixFives_ThenExpectTwoAndSix(){
		int[] testArr2 = new int[]{4,4,5,5,5,5,5,5};

		Map<Integer, Integer> tester2 = Einstiegsbeispiel.getRepetitions(testArr2);

		assertEquals(3,(int)tester2.get(2),"Test2 failed misserably");

	}

	@Test
	public void WhenEnteringNothing_ThenExpectError(){
		int[] testArr3 = new int[]{};



		try{
			Map<Integer,Integer> tester3 = Einstiegsbeispiel.getRepetitions(testArr3);
			assertEquals(1,(int)tester3.get(1),"Ok");
		}catch(NullPointerException npex){
			System.out.println("Tut uns leid ein leeres Array kann nicht bearbeitet werden.");
		}

	}

	@Test
	public void WhenEnteringTooManyNumbers_ThenExpectError(){
		int[] testArr4 = new int[]{0,0,1000,55,99,101010,54545,10};


		try{
			Map<Integer, Integer> tester4 = Einstiegsbeispiel.getRepetitions(testArr4);
			assertEquals(1,(int)tester4.get(101010),"Please fail");

		}catch(IllegalArgumentException iaex){
			System.out.println("Bitte auf die Reihenfolge Achten!");
		}



	}


}
