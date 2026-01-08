package business.businessVhsOnline;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import business.businessVhs.Volkshochschulkurs;
//Liskov Vererbung hier nur Attribut welches neu ist rest vird vonVHS geerbt
public class OnlineVolkshochschulkurs extends Volkshochschulkurs {
	
	private String plattform; // z.B. Zoom, Teams
	
	//CHAIN Konstruktor
	  public OnlineVolkshochschulkurs(
	            String kursname, int kursbeitrag, String wochentag,
	            float startuhrzeit, String[] vorkenntnisse, String plattform) {

	        this(kursname, kursbeitrag, wochentag, startuhrzeit, vorkenntnisse);
	        this.plattform = plattform;
	    }

	    // Konstruktor ohne Online-spezifisches Attribut
	    public OnlineVolkshochschulkurs(
	            String kursname, int kursbeitrag, String wochentag,
	            float startuhrzeit, String[] vorkenntnisse) {

	        super(kursname, kursbeitrag, wochentag, startuhrzeit, vorkenntnisse);
	        this.plattform = "Zoom"; // Default
	    }
	

    public String getPlattform() {
        return plattform;
    }

    public void setPlattform(String plattform) {
        this.plattform = plattform;
    }

    private void leseDatei(String dateiname) throws IOException {
        
    }

    public String gibOnlineKursZurueck(char trenner) {
        return super.gibVolkshochschuleZurueck(trenner).trim()
                + trenner + plattform + "\n";
    }
}


