package fileCreatorRau;

import java.io.IOException;

public class ConcreteReaderCreatorRau extends ReaderCreatorRau {

	@Override
	public ReaderProductRau factoryMethod(String typ) throws IOException {
		
		if("csv".equals(typ)) {
			return new ConcreteCsvReaderProductRau();
		}else {
			return new ConcreteTxtReaderProductRau();
		}
	}
	
	

}
