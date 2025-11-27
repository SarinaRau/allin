package main;



import gui.guiVolkshochschule.VolkshochschuleControl;
import gui.guiWissenschaft.WissenschaftUndBildungControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new VolkshochschuleControl(primaryStage);
		Stage fensterwissenschaft =new Stage();
		new WissenschaftUndBildungControl(fensterwissenschaft);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
