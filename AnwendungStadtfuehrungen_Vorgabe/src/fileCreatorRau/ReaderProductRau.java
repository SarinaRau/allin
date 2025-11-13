package fileCreatorRau;

import java.io.IOException;

public abstract class ReaderProductRau {
	
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;

}
