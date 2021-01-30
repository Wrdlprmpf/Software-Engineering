package at.aau.ue5.bsp3;

public class Main {
	public static void main(String[] args) {
		Person test = new Architekt("Johannes", "Kannes",44,Feld.ENTERPRISE);

		System.out.println(test.getJobBeschreibung());
	}
}
