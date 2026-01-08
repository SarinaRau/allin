package gui.guiWissenschaft;

import java.io.IOException;

import business.businessVhsOnline.OnlineVhsModel;
import business.businessVhsOnline.OnlineVolkshochschulkurs;
import business.businessVhs.VolkshochschuleModel;
import business.businessVhs.Volkshochschulkurs;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class WissenschaftUndBildungView {

	 private WissenschaftUndBildungControl wissenschaftUndBildungControl;
	    private VolkshochschuleModel volkshochschulkurseModel;
	    private OnlineVhsModel onlineVhsModel;

	    // --- GUI ---
	    private Pane pane = new Pane();

	    // LINKS: Online-VHS
	    private Label lblAnzeigeOnline =
	            new Label("Anzeige Online-VHS-Kurse");
	    private TextArea txtAnzeigeOnline = new TextArea();
	    private Button btnAnzeigeOnline =
	            new Button("Anzeige");

	    // RECHTS: Volkshochschulkurse
	    private Label lblAnzeigeVolkshochschulkurse =
	            new Label("Anzeige Volkshochschulkurse");
	    private TextArea txtAnzeigeVolkshochschulkurse = new TextArea();
	    private Button btnAnzeigeVolkshochschulkurse =
	            new Button("Anzeige");

	    private MenuBar menuBar = new MenuBar();
	    private Menu menuDatei = new Menu("Datei");
	    private MenuItem miCsvImport = new MenuItem("csv-Import");
	    private MenuItem miTxtImport = new MenuItem("txt-Import");

	    public WissenschaftUndBildungView(
	            WissenschaftUndBildungControl wissenschaftUndBildungControl,
	            Stage primaryStage,
	            VolkshochschuleModel volkshochschulkurseModel,
	            OnlineVhsModel onlineVhsModel) {

	        Scene scene = new Scene(this.pane, 560, 340);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Anzeige von Wissenschaft und Bildung");
	        primaryStage.show();

	        this.wissenschaftUndBildungControl = wissenschaftUndBildungControl;
	        this.volkshochschulkurseModel = volkshochschulkurseModel;
	        this.onlineVhsModel = onlineVhsModel;

	        this.initKomponentenLinks();
	        initKomponentenRechts();
	        initListener();
	    }

	    private void initKomponentenLinks() {
	        menuDatei.getItems().addAll(miCsvImport, miTxtImport);
	        menuBar.getMenus().add(menuDatei);

	        menuBar.setLayoutX(0);
	        menuBar.setLayoutY(0);
	        menuBar.setPrefWidth(560);
	        pane.getChildren().add(menuBar);

	        Font font = new Font("Arial", 20);
	        lblAnzeigeOnline.setLayoutX(30);
	        lblAnzeigeOnline.setLayoutY(40);
	        lblAnzeigeOnline.setFont(font);
	        lblAnzeigeOnline.setStyle("-fx-font-weight: bold;");
	        pane.getChildren().add(lblAnzeigeOnline);

	        txtAnzeigeOnline.setEditable(false);
	        txtAnzeigeOnline.setLayoutX(30);
	        txtAnzeigeOnline.setLayoutY(90);
	        txtAnzeigeOnline.setPrefWidth(220);
	        txtAnzeigeOnline.setPrefHeight(185);
	        pane.getChildren().add(txtAnzeigeOnline);

	        btnAnzeigeOnline.setLayoutX(30);
	        btnAnzeigeOnline.setLayoutY(290);
	        pane.getChildren().add(btnAnzeigeOnline);
	    }

	    private void initKomponentenRechts() {
	        Font font = new Font("Arial", 20);

	        lblAnzeigeVolkshochschulkurse.setLayoutX(310);
	        lblAnzeigeVolkshochschulkurse.setLayoutY(40);
	        lblAnzeigeVolkshochschulkurse.setFont(font);
	        lblAnzeigeVolkshochschulkurse.setStyle("-fx-font-weight: bold;");
	        pane.getChildren().add(lblAnzeigeVolkshochschulkurse);

	        txtAnzeigeVolkshochschulkurse.setEditable(false);
	        txtAnzeigeVolkshochschulkurse.setLayoutX(310);
	        txtAnzeigeVolkshochschulkurse.setLayoutY(90);
	        txtAnzeigeVolkshochschulkurse.setPrefWidth(220);
	        txtAnzeigeVolkshochschulkurse.setPrefHeight(185);
	        pane.getChildren().add(txtAnzeigeVolkshochschulkurse);

	        btnAnzeigeVolkshochschulkurse.setLayoutX(310);
	        btnAnzeigeVolkshochschulkurse.setLayoutY(290);
	        pane.getChildren().add(btnAnzeigeVolkshochschulkurse);
	    }

	    private void initListener() {
	        btnAnzeigeVolkshochschulkurse.setOnAction(
	                e -> zeigeVolkshochschulkurseAn());

	        btnAnzeigeOnline.setOnAction(
	                e -> zeigeOnlineKurseAn());

	        miCsvImport.setOnAction(e -> {
	            try {
	                onlineVhsModel.leseOnlineVhsAusCsvDatei();
	            } catch (IOException ex) {
	                zeigeInformationsfensterAn("CSV-Import fehlgeschlagen!");
	            }
	        });

	        miTxtImport.setOnAction(e -> {
	            try {
	                onlineVhsModel.leseOnlineVhsAusTxtDatei();
	            } catch (IOException ex) {
	                zeigeInformationsfensterAn("TXT-Import fehlgeschlagen!");
	            }
	        });
	    }

	    // ===== Volkshochschulkurse =====
	    public void zeigeVolkshochschulkurseAn() {
	        if (volkshochschulkurseModel.getVolkshochschulkurs().size() > 0) {
	            StringBuilder text = new StringBuilder();
	            for (Volkshochschulkurs kurs :
	                    volkshochschulkurseModel.getVolkshochschulkurs()) {
	                text.append(kurs.gibVolkshochschuleZurueck(' '))
	                        .append("\n");
	            }
	            txtAnzeigeVolkshochschulkurse.setText(text.toString());
	        } else {
	            zeigeInformationsfensterAn(
	                    "Bisher wurde kein Volkshochschulkurs aufgenommen!");
	        }
	    }

	    // ===== Online-VHS =====
	    public void zeigeOnlineKurseAn() {
	        if (onlineVhsModel.getOnlineKurse().size() > 0) {
	            StringBuilder text = new StringBuilder();
	            for (OnlineVolkshochschulkurs kurs : onlineVhsModel.getOnlineKurse()) {
	                text.append(kurs.gibOnlineKursZurueck(' '))
	                        .append("\n");
	            }
	            txtAnzeigeOnline.setText(text.toString());
	        } else {
	            zeigeInformationsfensterAn(
	                    "Bisher wurde kein Online-Kurs geladen!");
	        }
	    }

	    private void zeigeInformationsfensterAn(String meldung) {
	        new MeldungsfensterAnzeiger(
	                AlertType.INFORMATION,
	                "Information",
	                meldung
	        ).zeigeMeldungsfensterAn();
	    }
}
