package gui;


import java.io.IOException;

import business.VolkshochschuleModel;
import business.Volkshochschulkurs;
import javafx.stage.Stage;

public class VolkshochschuleControl {
	
	private VolkshochschuleView view;
	private VolkshochschuleModel model;
	
	public VolkshochschuleControl(Stage primaryStage) {
		this.model = new VolkshochschuleModel();
		this.view = new VolkshochschuleView(this, primaryStage, model);
	}
	

	void leseAusDatei(String typ){
    	try {
      		
      			model.leseVolkshochschuleAusDatei(typ);
      		
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
	
	public void nehmeVolkshochschuleAuf(String kursname, int kursbeitrag, String wochentag,
	       	float startuhrzeit, String[] vorkenntnisse){
    {
    	try{
    		model.setVolkshochschulkurs(new Volkshochschulkurs(kursname,kursbeitrag,wochentag,startuhrzeit,vorkenntnisse));
    		view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
    	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
     	}
    }
}


