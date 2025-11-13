package fileCreatorRau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProductRau extends ReaderProductRau {
	
BufferedReader ein;
	
	public ConcreteTxtReaderProductRau() throws IOException {
		ein=new BufferedReader(new FileReader("VolkshochschulkurseAusgabe.txt"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] kurse=new String[100];
		String zeile;
		zeile=ein.readLine();
		int i=0;
		while(i< kurse.length) {
			kurse[i]=zeile;
			zeile=ein.readLine();
			i++;
			
		}
		return kurse;
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		ein.close();
	}

}
