package business.businessVhs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fileCreatorRau.ConcreteReaderCreatorRau;
import fileCreatorRau.ReaderCreatorRau;
import fileCreatorRau.ReaderProductRau;
import observer.Observable;
import observer.Observer;

public class VolkshochschuleModel implements Observable {

	//Volkshochschulkurs volkshochschulkurs;
	
	ArrayList<Volkshochschulkurs>vhs=new ArrayList<>();
	
	private static VolkshochschuleModel theInstance=null;
	
	private VolkshochschuleModel() {
		
	}
	
	public static VolkshochschuleModel getInstance() {
		if(theInstance==null) {
			theInstance=new VolkshochschuleModel();
		}
		return theInstance;
	}
	
	public ArrayList<Volkshochschulkurs> getVolkshochschulkurs() {
		return vhs;
	}

	public void addVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
		this.vhs.add(volkshochschulkurs);
		notifyObservers();
	}

	public void schreibeVolkshochschulenInCsvDatei()throws IOException {
		
			BufferedWriter aus = new BufferedWriter(new FileWriter("VolkshochschulkurseAusgabe.csv", true));
			for(Volkshochschulkurs kurs:vhs) {
			aus.write(kurs.gibVolkshochschuleZurueck(';'));
			}
			aus.close();
   			
		
	}
	
	public void leseVolkshochschuleAusDatei(String typ) throws IOException {
		ReaderCreatorRau creator=new ConcreteReaderCreatorRau();
		ReaderProductRau reader=creator.factoryMethod(typ);
		ArrayList<Volkshochschulkurs>gelesen=reader.leseAusDatei();
		for(Volkshochschulkurs kurs:gelesen) {
			
			vhs.add(kurs);
		}
		reader.schliesseDatei();
		notifyObservers();
		
	}
	
	private Vector<Observer>observers=new Vector<>();

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
			observers.elementAt(i).update(this);
		}
		
	}
}
