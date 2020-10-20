//Wetscher Nicolas 11845621

import java.util.HashMap;
import java.util.Map;

public class Einstiegsbeispiel {
	public static void main(String[] args) {
		
		int[] array = new int[]{2,2,2,2,3,4,4,4,1};

		System.out.println(getRepetitions(array).values());

		Map<Integer,Integer> exm = getRepetitions(array);

		for (Integer ex : exm.keySet()) {
			System.out.print(ex+", ");

		}
	}

	public static Map<Integer, Integer> getRepetitions(int[] arr){

		if(arr.length==0){
			throw new NullPointerException();
		}
		for (int i = 1; i < arr.length ; i++) {
			if(arr[i-1]>arr[i]){
				throw new IllegalArgumentException();
			}

		}


		int[] testReihenfolge = new int[]{};

		HashMap<Integer, Integer> reps = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length ; i++) {
			if(reps.containsKey(arr[i])){
				reps.put(arr[i],reps.get(arr[i])+1);
			}
			else{
				reps.put(arr[i],1);
				}
			}
		return (Map)reps;
	}

}
