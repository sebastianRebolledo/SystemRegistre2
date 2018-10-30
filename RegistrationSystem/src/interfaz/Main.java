package interfaz;
	
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.PetClub;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static PetClub petClub= new PetClub();
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public PetClub darPetClub() {
		return petClub;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
