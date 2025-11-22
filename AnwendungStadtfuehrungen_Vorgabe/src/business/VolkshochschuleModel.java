package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorRau.ConcreteReaderCreatorRau;
import fileCreatorRau.ReaderCreatorRau;
import fileCreatorRau.ReaderProductRau;

public class VolkshochschuleModel {

	Volkshochschulkurs volkshochschulkurs;
	
	public Volkshochschulkurs getVolkshochschulkurs() {
		return volkshochschulkurs;
	}

	public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.volkshochschulkurs = volkshochschulkurs;
	}

	public void schreibeVolkshochschulenInCsvDatei()throws IOException {
		
			BufferedWriter aus = new BufferedWriter(new FileWriter("VolkshochschulkurseAusgabe.csv", true));
			aus.write(this.getVolkshochschulkurs().gibVolkshochschuleZurueck(';'));
			aus.close();
   			
		
	}
	
	public void leseVolkshochschuleAusDatei(String typ) throws IOException {
		ReaderCreatorRau creator=new ConcreteReaderCreatorRau();
		ReaderProductRau reader=creator.factoryMethod(typ);
		String[] zeile=reader.leseAusDatei();
		this.volkshochschulkurs=new Volkshochschulkurs (zeile[0], Integer.parseInt(zeile[1]),
				(zeile[2]),Float.parseFloat(zeile[3]), zeile[4].split("_"));
		reader.schliesseDatei();
		
	}
}
