package at.aau.ue5.bsp3;

public class Tester extends Person{
	private String bevorzugtesTestFramework;

	public Tester(String vorname, String nachname, Integer alter, String beruf, String bevorzugtesTestFramework) {
		super(vorname, nachname, alter, beruf);
		this.bevorzugtesTestFramework = bevorzugtesTestFramework;
	}
}
