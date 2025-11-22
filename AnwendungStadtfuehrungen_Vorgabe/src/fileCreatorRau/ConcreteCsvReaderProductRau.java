package fileCreatorRau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProductRau extends ReaderProductRau {

	BufferedReader ein;
	
	public ConcreteCsvReaderProductRau() throws IOException {
		ein=new BufferedReader(new FileReader("VolkshochschulkurseAusgabe.csv"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] zeile=ein.readLine().split(";");
		
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		ein.close();
	}
	
	
	
	

}
