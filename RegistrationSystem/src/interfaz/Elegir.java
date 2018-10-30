package interfaz;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Elegir {

	
	
@FXML
private Button btnRegistrarse;
@FXML
private Button btnConsultas;

	public Elegir() {
		
	}
	
	public void initialize() {
		
	}
	
	
	
	
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage; 
        Parent root;
        
        if(event.getSource()==btnRegistrarse){        
        
         stage=(Stage) btnRegistrarse.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Registry.fxml"));
      
         }
        else  {
    		
        	
        	
        	 stage=(Stage) btnConsultas.getScene().getWindow(); 
        	  root = FXMLLoader.load(getClass().getResource("Queries.fxml"));
        	

         }
        
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
       }

	
	
}
