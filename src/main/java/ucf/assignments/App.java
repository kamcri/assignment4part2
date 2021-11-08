package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewLists.fxml"));
            root = loader.load();
            stage.setTitle("To-Do List");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}

