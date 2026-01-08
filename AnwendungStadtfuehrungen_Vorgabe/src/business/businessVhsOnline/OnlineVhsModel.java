package business.businessVhsOnline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import business.businessVhs.Volkshochschulkurs;
import observer.Observable;
import observer.Observer;

public class OnlineVhsModel implements Observable {
	
	

	private ArrayList<OnlineVolkshochschulkurs> onlineKurse = new ArrayList<>();

    private static OnlineVhsModel theInstance = null;

    private OnlineVhsModel() {
    }

    public static OnlineVhsModel getInstance() {
        if (theInstance == null) {
            theInstance = new OnlineVhsModel();
        }
        return theInstance;
    }

    public ArrayList<OnlineVolkshochschulkurs> getOnlineKurse() {
        return onlineKurse;
    }
    
    public void leseOnlineVhsAusCsvDatei() throws IOException {

        ArrayList<OnlineVolkshochschulkurs> ergebnis = new ArrayList<>();
        BufferedReader ein = new BufferedReader(
                new FileReader("UnisLesen.csv"));

        String zeile = ein.readLine();
        String[] teile;

        while (zeile != null) {
            teile = zeile.split(";");

            ergebnis.add(new OnlineVolkshochschulkurs(
                    teile[0],                              // kursname
                    Integer.parseInt(teile[1]),            // kursbeitrag
                    teile[2],                              // wochentag
                    Float.parseFloat(teile[3]),            // startuhrzeit
                    teile[4].split("_"),                   // vorkenntnisse
                    teile[5]                               // plattform
            ));

            zeile = ein.readLine();
        }

        ein.close();
        this.onlineKurse = ergebnis;
        notifyObservers();
    }
    
    public void leseOnlineVhsAusTxtDatei() throws IOException {

        ArrayList<OnlineVolkshochschulkurs> ergebnis = new ArrayList<>();
        BufferedReader ein = new BufferedReader(
                new FileReader("UnisLesen.txt"));

        String zeile = ein.readLine();
        String[] teile;

        while (zeile != null) {
            teile = zeile.split(";");

            ergebnis.add(new OnlineVolkshochschulkurs(
                    teile[0],
                    Integer.parseInt(teile[1]),
                    teile[2],
                    Float.parseFloat(teile[3]),
                    teile[4].split("_"),
                    teile[5]
            ));

            zeile = ein.readLine();
        }

        ein.close();
        this.onlineKurse = ergebnis;
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
