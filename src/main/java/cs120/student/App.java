package cs120.student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class sets the stage and calls the other classes to create the font gui 
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    /*
     * This method shows the window and creates the frame
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480); //size of window
        scene.getStylesheets().add(App.class.getResource("Login.css").toExternalForm()); //calls css style file
        stage.setScene(scene);
        stage.show(); //shows window
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}