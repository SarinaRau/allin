package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fileCreatorRau.ConcreteReaderCreatorRau;
import fileCreatorRau.ReaderCreatorRau;
import fileCreatorRau.ReaderProductRau;
import observer.Observable;
import observer.Observer;

public class VolkshochschuleModel implements Observable {

	Volkshochschulkurs volkshochschulkurs;
	private static VolkshochschuleModel theInstance=null;
	
	private VolkshochschuleModel() {
		
	}
	
	public static VolkshochschuleModel getInstance() {
		if(theInstance==null) {
			theInstance=new VolkshochschuleModel();
		}
		return theInstance;
	}
	
	public Volkshochschulkurs getVolkshochschulkurs() {
		return volkshochschulkurs;
	}

	public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.volkshochschulkurs = volkshochschulkurs;
		notifyObservers();
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
		notifyObservers();
		
	}
	
	private Vector<Observer>observers=new Vector();

	@Override
	public void addObserver(Observer obs) {
		observers.addElement(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.removeElement(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++) {
			observers.elementAt(i).update();
		}
		
	}
}
