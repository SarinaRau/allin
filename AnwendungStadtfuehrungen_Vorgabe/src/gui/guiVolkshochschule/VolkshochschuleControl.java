package gui.guiVolkshochschule;


import java.io.IOException;


import business.businessVhs.VolkshochschuleModel;
import business.businessVhs.Volkshochschulkurs;
import javafx.stage.Stage;
import observer.Observable;
import observer.Observer;

public class VolkshochschuleControl implements Observer {
	
	private VolkshochschuleView view;
	private VolkshochschuleModel model;
	
	public VolkshochschuleControl(Stage primaryStage) {
		this.model = VolkshochschuleModel.getInstance();
		this.view = new VolkshochschuleView(this, primaryStage, model);
		model.addObserver(this);
		
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
    		model.addVolkshochschulkurs(new Volkshochschulkurs(kursname,kursbeitrag,wochentag,startuhrzeit,vorkenntnisse));
    		view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
    	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
     	}
    }


	@Override
	public void update(Observable obs) {
		
		    if (obs instanceof VolkshochschuleModel) {
		        view.zeigeVolkshochschulenAn();
		    }
		
	}
}


