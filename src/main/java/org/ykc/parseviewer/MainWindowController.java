package org.ykc.parseviewer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import org.controlsfx.control.StatusBar;

public class MainWindowController implements Initializable{
	
    @FXML // fx:id="borderPaneMainWindow"
    private BorderPane borderPaneMainWindow; // Value injected by FXMLLoader

    @FXML // fx:id="mItemExit"
    private MenuItem mItemExit; // Value injected by FXMLLoader

    @FXML // fx:id="menuItemAboutMe"
    private MenuItem menuItemAboutMe; // Value injected by FXMLLoader

    @FXML // fx:id="bOpen"
    private Button bOpen; // Value injected by FXMLLoader

    @FXML // fx:id="statusBar"
    private StatusBar statusBar; // Value injected by FXMLLoader

    @FXML // fx:id="aPaneMain"
    private AnchorPane aPaneMain; // Value injected by FXMLLoader
    
    private Stage myStage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void showAboutMe(ActionEvent event) {
    	displayAboutMe();
    }
    
    @FXML
    void exitApplication(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void open(ActionEvent event) {

    }

	public void setStage(Stage stage) {
        myStage = stage;
		myStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		      public void handle(WindowEvent we) {
		    	  /* TODO */
		      }
		  });
    }

	private void displayAboutMe() {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = getClass().getResource("/version.properties").openStream();
			prop.load(input);
		} catch (IOException e) {
		}
		String ver = prop.getProperty("MAJOR_VERSION") + "."+ prop.getProperty("MINOR_VERSION") + "." + prop.getProperty("BUILD_NO");
		MsgBox.display("About Me", "ParseViewer\nVersion: "+ ver +"\nAuthor: Tejender Sheoran\nEmail: tejendersheoran@gmail.com\nCopyright(C) (2016-2017) Tejender Sheoran\nThis program is free software. You can redistribute it and/or modify it\nunder the terms of the GNU General Public License Ver 3.\n<http://www.gnu.org/licenses/>");
	}
}

