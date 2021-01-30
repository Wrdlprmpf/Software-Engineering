package at.aau.ue5.bsp3;

public class Entwickler extends Person{
	private String bevorzugteProgrammierSprache;
	private Ide ide;
	private boolean datenbanken;

	public Entwickler(String vorname, String nachname, Integer alter, String beruf, String bevorzugteProgrammierSprache, Ide ide, boolean datenbanken) {
		super(vorname, nachname, alter, beruf);
		this.bevorzugteProgrammierSprache = bevorzugteProgrammierSprache;
		this.ide = ide;
		this.datenbanken = datenbanken;
	}
}
