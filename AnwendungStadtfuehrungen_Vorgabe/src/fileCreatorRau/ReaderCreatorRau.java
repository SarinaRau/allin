package fileCreatorRau;

import java.io.IOException;

public abstract class ReaderCreatorRau {
	
	public abstract ReaderProductRau factoryMethod(String typ)throws IOException;

}
