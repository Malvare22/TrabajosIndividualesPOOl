import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
    
public class UniversidadFX extends Application{
    

    public void start(Stage stage) throws IOException{
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "Matriculas.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        // Create the Pane and all Details
        Pane root = (Pane) loader.load(fxmlStream);

        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Gestor de prematrículas");
        stage.getIcons().add(new Image("imagen Icono.png"));
        //stage.resizableProperty().setValue(Boolean.FALSE);
        // Display the Stage
        stage.show();
    }

}
