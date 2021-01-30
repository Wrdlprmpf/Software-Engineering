package at.aau.ue5.bsp3;

public class Architekt extends Person{
	private Feld feld;

	public Architekt(String vorname, String nachname, Integer alter, String beruf, Feld feld) {
		super(vorname, nachname, alter, beruf);
		this.feld = feld;
	}

}
