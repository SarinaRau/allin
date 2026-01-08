package gui.guiWissenschaft;


import gui.guiWissenschaft.WissenschaftUndBildungView;

import com.sun.glass.ui.View;


import business.businessVhs.VolkshochschuleModel;
import business.businessVhsOnline.OnlineVhsModel;
import javafx.stage.Stage;
import observer.Observable;
import observer.Observer;

	public class WissenschaftUndBildungControl implements Observer {	
		
	
		private WissenschaftUndBildungView wissenschaftUndBildungView;
		private VolkshochschuleModel volkshochschuleModel;
		private OnlineVhsModel onlineModel;
		
		public WissenschaftUndBildungControl(Stage primaryStage){
	 		this.volkshochschuleModel = VolkshochschuleModel.getInstance(); 
	 		this.onlineModel=OnlineVhsModel.getInstance();
			this.wissenschaftUndBildungView = new WissenschaftUndBildungView(this, primaryStage,volkshochschuleModel,onlineModel);
			volkshochschuleModel.addObserver(this);
			onlineModel.addObserver(this); 
		}

		//separierung in vhs und online ist schon ExtractMethod
		@Override
		public void update(Observable obs) {
			 if (obs instanceof OnlineVhsModel) {
			        wissenschaftUndBildungView.zeigeOnlineKurseAn();
			    }

			    if (obs instanceof VolkshochschuleModel) {
			        wissenschaftUndBildungView.zeigeVolkshochschulkurseAn();
			    }
			
		}
	}


