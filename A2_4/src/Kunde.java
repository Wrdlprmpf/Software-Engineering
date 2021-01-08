public class Kunde {
	public Kunde(int knummer, int abodauer, int alter) throws Exception{
		if(alter < 14 || alter > 122){
			throw new Exception("ungültiges Alter");
		}
		if(knummer > 9000 || knummer < 5000){
			throw new Exception("ungültige Kundennummer");
		}
		if(abodauer > 24 || abodauer < 1){
			throw new Exception("ungültige Abodauer");
		}

		this.knummer = knummer;
		this.abodauer = abodauer;
		this.alter = alter;
		
	}

	private int knummer;
	private int abodauer;
	private int alter;

	public int getKnummer() {
		return knummer;
	}

	public void setKnummer(int knummer) throws Exception{
		if(knummer > 9000 || knummer < 5000){
			throw new Exception("ungültige Kundennummer");
		}
		this.knummer = knummer;
	}

	public int getAbodauer() {
		return abodauer;
	}

	public void setAbodauer(int abodauer) throws Exception{
		if(abodauer > 24 || abodauer < 1){
			throw new Exception("ungültige Abodauer");
		}
		this.abodauer = abodauer;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) throws Exception{
		if(alter < 14 || alter > 122){
			throw new Exception("ungültiges Alter");
		}
		this.alter = alter;
	}
}
