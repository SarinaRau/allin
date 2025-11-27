package gui.guiWissenschaft;


import gui.guiWissenschaft.WissenschaftUndBildungView;

import com.sun.glass.ui.View;

import business.VolkshochschuleModel;
import javafx.stage.Stage;
import observer.Observer;

	public class WissenschaftUndBildungControl implements Observer {	
		
	
		private WissenschaftUndBildungView wissenschaftUndBildungView;
		private VolkshochschuleModel volkshochschuleModel;
		
		public WissenschaftUndBildungControl(Stage primaryStage){
	 		this.volkshochschuleModel = VolkshochschuleModel.getInstance(); 		
			this.wissenschaftUndBildungView = new WissenschaftUndBildungView(this, primaryStage,volkshochschuleModel);
			volkshochschuleModel.addObserver(this);
		}

		@Override
		public void update() {
			wissenschaftUndBildungView.zeigeVolkshochschulkurseAn();
			
		}
	}


