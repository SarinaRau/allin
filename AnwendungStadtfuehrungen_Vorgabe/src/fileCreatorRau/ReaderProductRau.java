package fileCreatorRau;

import java.io.IOException;
import java.util.ArrayList;

import business.Volkshochschulkurs;

public abstract class ReaderProductRau {
	
	public abstract ArrayList<Volkshochschulkurs> leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;

}
