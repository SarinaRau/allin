package fileCreatorRau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import business.Volkshochschulkurs;
public class ConcreteTxtReaderProductRau extends ReaderProductRau {
	
BufferedReader ein;
	
	public ConcreteTxtReaderProductRau() throws IOException {
		ein=new BufferedReader(new FileReader("VolkshochschulkurseAusgabe.txt"));
	}
	
	@Override
	public ArrayList<Volkshochschulkurs> leseAusDatei() throws IOException {
		ArrayList<Volkshochschulkurs>vhs=new ArrayList<>();
		String[] zeile=null;
		String zeileeinzeln=ein.readLine();
		
		while(zeileeinzeln!=null) {
			zeile=zeileeinzeln.split(";");
			vhs.add(new Volkshochschulkurs(
					zeile[0],
					Integer.parseInt(zeile[1]),
					zeile[2],
					Float.parseFloat(zeile[3]),
					zeile[4].split("_")));
			zeileeinzeln=ein.readLine();
			
		}
		return vhs;
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		ein.close();
	}

}
