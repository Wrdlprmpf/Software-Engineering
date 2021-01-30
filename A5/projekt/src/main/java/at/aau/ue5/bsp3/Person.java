package at.aau.ue5.bsp3;

/*public class Person {
    public String vorname,nachname;
    public Integer alter;
    public String beruf;
    public String bevorzugteProgrammierSprache;
    public String ide;
    public boolean datenbanken;
    public String feld;
    public String bevorzugtesTestFramework;

    public String getJobBeschreibung() {
        switch(beruf) {
            case "Entwickler": return "Entwickelt Code.";
            case "Architekt": return "Designed die Architektur des Projekts.";
            case "Tester": return "Testet Code.";
            default: return "";
        }
    }
}

 */
public abstract class Person{
    private String vorname, nachname;
    private Integer alter;

    public Person(String vorname, String nachname, Integer alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public abstract String getJobBeschreibung();

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Integer getAlter() {
        return alter;
    }
}